package org.dhbw.ka.ml.petrilib.serializing.primitives;

import javax.xml.crypto.Data;
import java.io.*;

public class PetriDouble {

    public static int serialize(double value, DataOutput out) throws IOException {
        out.writeDouble(value);
        return serializedByteLength();
    }

    public static double deserialize(DataInput in) throws IOException {
        return in.readDouble();
    }

    public static void skip(DataInput in) throws IOException {
        in.skipBytes(serializedByteLength());
    }

    public static int serializedByteLength() {
        return 8;
    }

}
