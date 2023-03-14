package org.dhbw.ka.ml.petrilib.serializing.primitives;

import java.io.*;

public class PetriBool {

    public static int serialize(boolean value, DataOutput out) throws IOException {
        out.writeBoolean(value);
        return 1;
    }

    public static boolean deserialize(DataInput in) throws IOException {
        return in.readBoolean();
    }

}
