package system.core.interceptor;
import java.beans.PropertyEditorSupport;
import java.text.SimpleDateFormat;
import org.springframework.util.StringUtils;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;
public class DateConvertEditor extends PropertyEditorSupport {
	private SimpleDateFormat dateFormat = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm:ss");
	private SimpleDateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd");
	public void setAsText(String text) {
		if (StringUtils.hasText(text)) {
			try {
				if (text.indexOf(":") == -1 || text.length() == 10) {
					setValue(this.dateFormat2.format(text));
				} else if (text.indexOf(":") > 0 && text.length() == 19) {
					setValue(this.dateFormat.format(text));
				} else if (text.indexOf(":") > 0 && text.length() == 21) {
					setValue(this.dateFormat.format(text.replace(".0", "")));
				} else if (text.indexOf(":") > 0 && text.length() == 23) {
					setValue(this.dateFormat.format(text.substring(0, 21)
							.replace(".0", "")));
				} else {
					throw new IllegalArgumentException(
							"Could not parse date , date format is error");
				}
			} catch (ParseException exception) {
				IllegalArgumentException argumentException = new IllegalArgumentException(
						"Culd not parse date:" + exception.getMessage());
				argumentException.initCause(exception);
				throw argumentException;
			}
		} else {
			setValue(null);
		}
	}
}
