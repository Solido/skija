package org.jetbrains.skija;

import org.jetbrains.annotations.*;
import org.jetbrains.skija.impl.RefCnt;
import org.jetbrains.skija.impl.Stats;

public class Context extends RefCnt {
    static { Library.load(); }
    
    public static Context makeGL() {
        Stats.onNativeCall();
        return new Context(_nMakeGL());
    }

    public void flush() {
        Stats.onNativeCall();
        _nFlush(_ptr);
    }

    @ApiStatus.Internal
    public Context(long ptr) {
        super(ptr);
    }

    public static native long _nMakeGL();
    public static native long _nFlush(long ptr);
}