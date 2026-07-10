package defpackage;

import java.io.File;
import java.io.FileFilter;
import java.util.regex.Pattern;

final class kid implements FileFilter {
    kid() {
    }

    @Override // java.io.FileFilter
    public final boolean accept(File file) {
        return Pattern.matches("cpu[0-9]+", file.getName());
    }
}