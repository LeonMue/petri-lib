package org.dhbw.ka.ml.petrilib.io;

import java.io.DataInput;
import java.io.DataInputStream;
import java.io.IOException;

public class ReadTrackingDataInput implements DataInput {

    private int bytesWasRead = 0;
    private DataInput in;

    public ReadTrackingDataInput(DataInputStream in) {
        this.in = in;
    }

    public ReadTrackingDataInput(ReadTrackingDataInput in) {
        this.in = in.in;
    }

    public void addToWasRead(int i) {
        this.bytesWasRead += i;
    }

    @Override
    public void readFully(byte[] b) throws IOException {
        this.in.readFully(b);
        this.bytesWasRead += b.length;
    }

    @Override
    public void readFully(byte[] b, int off, int len) throws IOException {
        this.in.readFully(b, off, len);
        this.bytesWasRead += len;
    }

    @Override
    public int skipBytes(int n) throws IOException {
        final int i = this.in.skipBytes(n);
        this.bytesWasRead += i;
        return i;
    }

    @Override
    public boolean readBoolean() throws IOException {
        final boolean result = this.in.readBoolean();
        this.bytesWasRead++;
        return result;
    }

    @Override
    public byte readByte() throws IOException {
        final byte result = this.in.readByte();
        this.bytesWasRead++;
        return result;
    }

    @Override
    public int readUnsignedByte() throws IOException {
        final int result = this.in.readUnsignedByte();
        this.bytesWasRead++;
        return result;
    }

    @Override
    public short readShort() throws IOException {
        final short result = this.in.readShort();
        this.bytesWasRead += 2;
        return result;
    }

    @Override
    public int readUnsignedShort() throws IOException {
        final int result = this.in.readUnsignedShort();
        this.bytesWasRead += 2;
        return result;
    }

    @Override
    public char readChar() throws IOException {
        final char result = this.in.readChar();
        this.bytesWasRead += 2;
        return result;
    }

    @Override
    public int readInt() throws IOException {
        final int result = this.in.readInt();
        this.bytesWasRead += 4;
        return result;
    }

    @Override
    public long readLong() throws IOException {
        final long result = this.in.readLong();
        this.bytesWasRead += 8;
        return result;
    }

    @Override
    public float readFloat() throws IOException {
        final float result = this.in.readFloat();
        this.bytesWasRead += 4;
        return result;
    }

    @Override
    public double readDouble() throws IOException {
        final double result = this.in.readDouble();
        this.bytesWasRead += 8;
        return result;
    }

    @Override
    @Deprecated
    public String readLine() throws IOException {
        return this.in.readLine();
    }

    @Override
    public String readUTF() throws IOException {
        return this.in.readUTF();
    }

    public int getBytesWasRead() {
        return bytesWasRead;
    }
}
