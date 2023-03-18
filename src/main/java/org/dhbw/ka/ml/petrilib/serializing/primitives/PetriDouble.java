package org.dhbw.ka.ml.petrilib.serializing.primitives;

import java.io.*;

public class PetriDouble {

    public static int serialize(double value, DataOutput out) throws IOException {
        out.writeDouble(value);
        return byteSize();
    }

    public static double deserialize(DataInput in) throws IOException {
        return in.readDouble();
    }

    public static int byteSize() {
        return 8;
    }

}
