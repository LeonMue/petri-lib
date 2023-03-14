package org.dhbw.ka.ml.petrilib.serializing;

import com.clearspring.analytics.util.Varint;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class VarInt {

    public static byte[] serializeUnsigned(int value) {
        return Varint.writeUnsignedVarInt(value);
    }

    public static byte[] serializeSigned(int value) {
        return Varint.writeSignedVarInt(value);
    }

    public static int deserializeUnsigned(DataInput in) throws IOException {
        return Varint.readUnsignedVarInt(in);
    }

    public static int deserializeSigned(DataInput in) throws IOException {
        return Varint.readSignedVarInt(in);
    }

}
