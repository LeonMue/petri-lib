package org.dhbw.ka.ml.petrilib.serializing.primitives;

import org.dhbw.ka.ml.petrilib.serializing.VarInt;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class PetriInt {

    public static int serialize(int value, DataOutput out) throws IOException {
        byte[] serialized = VarInt.serializeSigned(value);
        out.write(serialized);
        return serialized.length;
    }

    public static int deserialize(DataInput in) throws IOException {
        return VarInt.deserializeSigned(in);
    }

}
