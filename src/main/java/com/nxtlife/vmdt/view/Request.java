package com.nxtlife.vmdt.view;

import com.nxtlife.vmdt.util.DateUtil;
import com.nxtlife.vmdt.util.LongObfuscator;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public interface Request {

	default Long unmask(final Long number) {
		return number != null ? LongObfuscator.INSTANCE.unobfuscate(number) : null;
	}

	default Date parseDate(String string, String dateFormat) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
		sdf.setLenient(false);
		return sdf.parse(string);
	}

	default Date parseDate(String string) throws ParseException {
		return parseDate(string, DateUtil.defaultFormat);
	}
}