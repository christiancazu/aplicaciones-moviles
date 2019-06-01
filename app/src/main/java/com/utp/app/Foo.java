package com.utp.app;

public class Foo {
    private boolean boo;
    private ChangeListener listener;

    public boolean isFoo() {
        return boo;
    }

    public void setFoo(boolean boo) {
        this.boo = boo;
        if (listener != null) listener.onChange();
    }

    public ChangeListener getListener() {
        return listener;
    }

    public void setListener(ChangeListener listener) {
        this.listener = listener;
    }

    public interface ChangeListener {
        void onChange();
    }


}
