package com.nxtlife.vmdt.view;


import com.nxtlife.vmdt.util.LongObfuscator;

public interface Response {

    default Long mask(final Long number) {
        return number != null ? LongObfuscator.INSTANCE.obfuscate(number) : null;
    }
}
