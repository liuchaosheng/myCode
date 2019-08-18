package club.zylearn.maven.persondemo.webmodule.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

// 进行参数跟日期类型转换的定义
public class DateConverter implements Converter<String, Date> {

	@Override
	public Date convert(String source) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date target = null;
		try {
			target = sdf.parse(source);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return target;
	}

	
}
