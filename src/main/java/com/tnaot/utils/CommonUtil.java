package com.tnaot.utils;

import java.io.*;
import java.util.List;

public class CommonUtil {

    public static <T> List<T> deepCopy(List<T> src){
        try {
            ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
            ObjectOutputStream out = new ObjectOutputStream(byteOut);
            out.writeObject(src);

            ByteArrayInputStream byteIn = new ByteArrayInputStream(byteOut.toByteArray());
            ObjectInputStream in = new ObjectInputStream(byteIn);
            @SuppressWarnings("unchecked")
            List<T> dest = (List<T>) in.readObject();
            return dest;
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
