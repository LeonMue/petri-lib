package org.dhbw.ka.ml.petrilib.serializing;

import com.clearspring.analytics.util.Varint;

import java.io.*;

public class VarLong {

    public static byte[] serializeUnsigned(long value) {
        try (ByteArrayOutputStream result = new ByteArrayOutputStream()) {
            Varint.writeUnsignedVarLong(value, new DataOutputStream(result));
            return result.toByteArray();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static byte[] serializeSigned(long value) {
        try (ByteArrayOutputStream result = new ByteArrayOutputStream()) {
            Varint.writeSignedVarLong(value, new DataOutputStream(result));
            return result.toByteArray();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static long deserializeUnsigned(DataInput in) throws IOException {
        return Varint.readUnsignedVarLong(in);
    }

    public static long deserializeSigned(DataInput in) throws IOException {
        return Varint.readSignedVarLong(in);
    }

}
