package org.dhbw.ka.ml.petrilib.io;

import java.io.*;

public class PetriWriter extends OutputStream implements DataOutput, AutoCloseable {

    private ByteArrayOutputStream bout;

    private DataOutputStream dout;

    public PetriWriter() {
        this.bout = new ByteArrayOutputStream();
        this.dout = new DataOutputStream(this.bout);
    }

    @Override
    public void writeBoolean(boolean v) throws IOException {
        this.dout.writeBoolean(v);
    }

    @Override
    public void writeByte(int v) throws IOException {
        this.dout.writeByte(v);
    }

    @Override
    public void writeShort(int v) throws IOException {
        this.dout.writeShort(v);
    }

    @Override
    public void writeChar(int v) throws IOException {
        this.dout.writeChar(v);
    }

    @Override
    public void writeInt(int v) throws IOException {
        this.dout.writeInt(v);
    }

    @Override
    public void writeLong(long v) throws IOException {
        this.dout.writeLong(v);
    }

    @Override
    public void writeFloat(float v) throws IOException {
        this.dout.writeFloat(v);
    }

    @Override
    public void writeDouble(double v) throws IOException {
        this.dout.writeDouble(v);
    }

    @Override
    public void writeBytes(String s) throws IOException {
        this.dout.writeBytes(s);
    }

    @Override
    public void writeChars(String s) throws IOException {
        this.dout.writeChars(s);
    }

    @Override
    public void writeUTF(String s) throws IOException {
        this.dout.writeUTF(s);
    }

    @Override
    public void write(int b) throws IOException {
        this.dout.write(b);
    }

    public void writeBytes(byte[] b) throws IOException {
        this.dout.write(b);
    }

    public int size() {
        return this.bout.size();
    }

    public void writeTo(OutputStream o) throws IOException {
        this.bout.writeTo(o);
    }

    public byte[] toByteArray() {
        return this.bout.toByteArray();
    }
}
