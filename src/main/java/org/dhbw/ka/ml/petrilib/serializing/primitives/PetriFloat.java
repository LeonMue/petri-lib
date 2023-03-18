package org.dhbw.ka.ml.petrilib.serializing.primitives;

import java.io.*;

public class PetriFloat {

    public static int serialize(float value, DataOutput out) throws IOException {
        out.writeFloat(value);
        return serializedByteLength();
    }

    public static float deserialize(DataInput in) throws IOException {
        return in.readFloat();
    }

    public static void skip(DataInput in) throws IOException {
        in.skipBytes(serializedByteLength());
    }

    public static int serializedByteLength() {
        return 4;
    }

}
