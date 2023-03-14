package org.dhbw.ka.ml.petrilib.serializing.primitives;

import org.dhbw.ka.ml.petrilib.serializing.VarLong;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class PetriLong {

    public static int serialize(long value, DataOutput out) throws IOException {
        byte[] serialized = VarLong.serializeSigned(value);
        out.write(serialized);
        return serialized.length;
    }

    public static float deserialize(DataInput in) throws IOException {
        return VarLong.deserializeSigned(in);
    }

}
