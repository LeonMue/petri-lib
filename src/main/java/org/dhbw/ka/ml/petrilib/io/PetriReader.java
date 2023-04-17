package org.dhbw.ka.ml.petrilib.io;

import java.io.ByteArrayInputStream;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.IOException;

public class PetriReader implements DataInput, AutoCloseable {

    private final byte[] input;

    private final DataInput din;

    private int offset = 0;

    public PetriReader(byte[] input) {
        this.input = input;
        this.din = new DataInputStream(new ByteArrayInputStream(input));
    }

    @Override
    public void readFully(byte[] b) throws IOException {
        this.din.readFully(b);
        this.offset += b.length;
    }

    @Override
    public void readFully(byte[] b, int off, int len) throws IOException {
        this.din.readFully(b, off, len);
        this.offset += len;
    }

    @Override
    public int skipBytes(int n) throws IOException {
        final int skipped = this.din.skipBytes(n);
        this.offset += skipped;
        return skipped;
    }

    @Override
    public boolean readBoolean() throws IOException {
        boolean result = this.din.readBoolean();
        this.offset++;
        return result;
    }

    @Override
    public byte readByte() throws IOException {
        byte result = this.din.readByte();
        this.offset++;
        return result;
    }

    @Override
    public int readUnsignedByte() throws IOException {
        int result = this.din.readUnsignedByte();
        this.offset++;
        return result;
    }

    @Override
    public short readShort() throws IOException {
        final short result = this.din.readShort();
        this.offset += 2;
        return result;
    }

    @Override
    public int readUnsignedShort() throws IOException {
        final int result = this.din.readUnsignedShort();
        this.offset += 2;
        return result;
    }

    @Override
    public char readChar() throws IOException {
        final char result = this.din.readChar();
        this.offset += 2;
        return result;
    }

    @Override
    public int readInt() throws IOException {
        final int result = this.din.readInt();
        this.offset += 4;
        return result;
    }

    @Override
    public long readLong() throws IOException {
        final long result = this.din.readLong();
        this.offset += 8;
        return result;
    }

    @Override
    public float readFloat() throws IOException {
        final float result = this.din.readFloat();
        this.offset += 4;
        return result;
    }

    @Override
    public double readDouble() throws IOException {
        final double result = this.din.readDouble();
        this.offset += 8;
        return result;
    }

    @Deprecated
    @Override
    public String readLine() throws IOException {
        return null;
    }

    @Deprecated
    @Override
    public String readUTF() throws IOException {
        return null;
    }

    public int getOffset() {
        return offset;
    }

    public byte getByteAt(int i) {
        return this.input[i];
    }

    @Override
    public void close() throws IOException {
        ((DataInputStream) this.din).close();
    }
}
