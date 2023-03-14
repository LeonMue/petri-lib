package org.dhbw.ka.ml.petrilib.serializing.primitives;

import org.dhbw.ka.ml.petrilib.serializing.VarInt;

import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class PetriString {

    public static int serialize(String value, DataOutput out) throws IOException {
        byte[] serializedString = value.getBytes(StandardCharsets.UTF_8);
        byte[] serializedLength = VarInt.serializeUnsigned(serializedString.length);

        out.write(serializedLength);
        out.write(serializedString);

        return serializedLength.length + serializedString.length;
    }

    public static String deserialize(DataInput in) throws IOException {
        int lengthOfSerializedString = VarInt.deserializeUnsigned(in);

        byte[] serializedString = new byte[lengthOfSerializedString];
        in.readFully(serializedString, 0, serializedString.length);

        return new String(serializedString, StandardCharsets.UTF_8);
    }

}
