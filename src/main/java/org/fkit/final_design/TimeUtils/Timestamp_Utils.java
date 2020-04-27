package org.fkit.final_design.TimeUtils;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.util.Converter;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.support.GenericConversionService;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.support.ConfigurableWebBindingInitializer;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.PostConstruct;

@Configuration
public class Timestamp_Utils implements Converter<String,Timestamp>
{

	public final SimpleDateFormat defaultDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	@Override
	public Timestamp convert(String text) {
		Timestamp timestamp=null;
        if(StringUtils.hasText(text)){
            text = text.trim();
            boolean isLong = true;
            try {
                long millisecond = Long.parseLong(text);
                timestamp=new Timestamp(millisecond);
            }catch(Exception e){
                isLong = false;
            }
            if(!isLong) {
                try {
                    SimpleDateFormat sdf = new SimpleDateFormat(FormatUtils.getFormatter(text.length()));
                    String format = defaultDateFormat.format(sdf.parse(text));
                    System.out.println(format);
                } catch (ParseException var3) {
                    throw new IllegalArgumentException("Could not parse date: " + var3.getMessage(), var3);
                }
            }
        }
        return timestamp;
	}
	@Override
	public JavaType getInputType(TypeFactory typeFactory) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public JavaType getOutputType(TypeFactory typeFactory) {
		// TODO Auto-generated method stub
		return null;
	}

}
	
