package defpackage;

import java.nio.ByteBuffer;

public interface mqn {
    ByteBuffer getBuffer();

    int getPixelStride();

    int getRowStride();
}