package system.core.util;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import system.core.enums.BrowserTypeEnum;

public class BrowserUtils {
	private final static String IE11 = "rv:11.0";
	private final static String IE10 = "MSIE 10.0";
	private final static String IE9 = "MSIE 9.0";
	private final static String IE8 = "MSIE 8.0";
	private final static String IE7 = "MSIE 7.0";
	private final static String IE6 = "MSIE 6.0";
	private final static String MAXTHON = "Maxthon";
	private final static String QQ = "QQBrowser";
	private final static String GREEN = "GreenBrowser";
	private final static String SE360 = "360SE";
	private final static String FIREFOX = "Firefox";
	private final static String OPERA = "Opera";
	private final static String CHROME = "Chrome";
	private final static String SAFARI = "Safari";
	private final static String OTHER = "其它";
	/**
	 * 判断是否是IE浏览器
	 * @param request
	 * @return
	 */
	public static boolean isIE(HttpServletRequest request){
		return request.getHeader("User-Agent").toLowerCase().indexOf("msie")>0||
				request.getHeader("User-Agent").toLowerCase().indexOf("rv:11.0")>0?true:false;
	}
	/**
	 * 判断IE的版本
	 * @param request
	 * @return
	 */
	public static double getIEVersion(HttpServletRequest request){
		double version = 0.0;
		if (getBrowserType(request, "IE6")) {
			version = 6.0;
		}else if(getBrowserType(request, "IE7")){
			version = 7.0;
		}else if(getBrowserType(request, "IE8")){
			version = 8.0;
		}else if (getBrowserType(request, "IE9")) {
			version = 9.0;
		}else if (getBrowserType(request, "IE10")) {
			version = 10.0;
		}
		return version;
	}
	/**
	 * 判断某个浏览器是否是某种类型浏览器
	 * @param request
	 * @param browserType
	 * @return
	 */
	public static boolean getBrowserType(HttpServletRequest request,String browserType){
		return request.getHeader("User-Agent").toLowerCase().indexOf(browserType)>0?true:false;
	}
	public static BrowserTypeEnum getBrowserType(HttpServletRequest request){
		BrowserTypeEnum browserTypeEnum = null;
		if (getBrowserType(request, IE11)) {
			browserTypeEnum = BrowserTypeEnum.IE11;
		}else if(getBrowserType(request, IE10)){
			browserTypeEnum = BrowserTypeEnum.IE10;
		}else if(getBrowserType(request, IE9)){
			browserTypeEnum = BrowserTypeEnum.IE9;
		}else if(getBrowserType(request, IE8)){
			browserTypeEnum = BrowserTypeEnum.IE8;
		}else if(getBrowserType(request, IE7)){
			browserTypeEnum = BrowserTypeEnum.IE7;
		}else if(getBrowserType(request, IE6)){
			browserTypeEnum = BrowserTypeEnum.IE6;
		}else if (getBrowserType(request, FIREFOX)) {
			browserTypeEnum = BrowserTypeEnum.Firefox;
		}else if (getBrowserType(request, CHROME)) {
			browserTypeEnum = BrowserTypeEnum.Chrome;
		}else if (getBrowserType(request, SAFARI)) {
			browserTypeEnum = BrowserTypeEnum.Safari;
		}else if(getBrowserType(request, QQ)){
			browserTypeEnum = BrowserTypeEnum.QQ;
		}else if (getBrowserType(request, MAXTHON)) {
			browserTypeEnum = BrowserTypeEnum.MAXTHON;
		}else if (getBrowserType(request, GREEN)) {
			browserTypeEnum = BrowserTypeEnum.GREEN;
		}else if (getBrowserType(request, SE360)) {
			browserTypeEnum = BrowserTypeEnum.SE360;
		}else if (getBrowserType(request, OPERA)) {
			browserTypeEnum = BrowserTypeEnum.Opera;
		}else{
			browserTypeEnum = BrowserTypeEnum.OTHER;
		}
		return browserTypeEnum;
	}
	/**
	 * 正则表达式
	 * @param regex
	 * @param str
	 * @return
	 */
	public static boolean regex(String regex,String str){
		Pattern pattern = Pattern.compile(regex,Pattern.MULTILINE);
		Matcher matcher = pattern.matcher(str);
		return matcher.find();
	}
	public static String checkBrowser(HttpServletRequest request){
		String user_agent = request.getHeader("USER_AGENT");
		if (regex(CHROME, user_agent)) {
			return CHROME;
		}
		if (regex(FIREFOX, user_agent)) {
			return FIREFOX;
		}
		if (regex(GREEN, user_agent)) {
			return GREEN;
		}
		if (regex(IE10, user_agent)) {
			return IE10;
		}
		if (regex(IE11, user_agent)) {
			return IE11;
		}
		if (regex(IE6, user_agent)) {
			return IE6;
		}
		if (regex(IE7, user_agent)) {
			return IE7;
		}
		if (regex(IE8, user_agent)) {
			return IE8;
		}
		if (regex(IE9, user_agent)) {
			return IE9;
		}
		if (regex(MAXTHON, user_agent)) {
			return MAXTHON;
		}
		if (regex(OPERA, user_agent)) {
			return OPERA;
		}
		if (regex(QQ, user_agent)) {
			return QQ;
		}
		if (regex(SAFARI, user_agent)) {
			return SAFARI;
		}
		if (regex(SE360, user_agent)) {
			return SE360;
		}
		return OTHER;
	}
	/**
	 * 获取浏览器编码
	 * @param request
	 * @return
	 */
	public static String getBrowserLanguage(HttpServletRequest request){
		String browserLanguage = request.getLocale().getLanguage();
		String browserLanguageCode = (String)languageMap.get(browserLanguage);
		if (browserLanguageCode==null) {
			browserLanguageCode = EN_US;
		}
		return browserLanguageCode;
	}
	private static Map<String, String> languageMap = new HashMap<String, String>();
	private static String ZH = "zh";
	private static String ZH_CN = "zh-cn";
	private static String EN = "en";
	private static String EN_US = "en-us";
	static{
		languageMap.put(ZH, ZH_CN);
		languageMap.put(EN,EN_US);
	}
}
