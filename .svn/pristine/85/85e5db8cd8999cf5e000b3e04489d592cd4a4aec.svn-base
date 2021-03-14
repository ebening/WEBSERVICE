package com.uadec.core.util;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public final class MimeType{
	static{
		new Type("application/word", 	  			"docx","doc", "dot", "rtf");
		new Type("application/octet-stream",		"bin","dms","lha","lzh","exe","class");
		new Type("application/pdf", 				"pdf");
		new Type("application/rtf", 				"rft");
		new Type("application/lotus-1-2-3", 		"123","wk4","wk3","wk1", "wks", "wg1");
		new Type("application/lotus-freelance",		"prz","pre");
		new Type("application/lotus-wordpro", 		"lwp","sam","mwp","smm");
		new Type("application/vnd.ms-excel", 		"xlsx","xls", "xlt", "xlm", "xld", "xla", "xlc", "xlw", "xll");
		new Type("application/vnd.ms-powerpoint", 	"ppt", "pot", "ppa", "pps", "pwz");
		new Type("application/vnd.visio", 			"vsd");
		new Type("audio/basic", 					"au", "snd", "ulw");
		new Type("audio/mpeg", 						"mpeg", "mpg", "m1s", "m1a", "mp2", "mp3", "mpm", "mpa", "mpga");
		new Type("audio/x-aiff", 					"aif", "aiff", "aifc");
		new Type("audio/x-midi", 					"midi", "mid", "smf", "kar");
		new Type("audio/x-wav", 					"wav");
		new Type("image/bmp", 						"bmp", "dib");
		new Type("image/gif", 						"gif");
		new Type("image/jpeg", 						"jpeg", "jpg", "jpe", "jfif", "pjpeg", "pjp");
		new Type("image/png", 						"png");
		new Type("image/tiff", 						"tiff","tif");
		new Type("text/csv",						"csv");
		new Type("text/html", 						"html", "htm", "shtml", "plg");
		new Type("text/plain", 						"txt", "text");
		new Type("text/xml", 						"xml", "dtd");
		new Type("video/vmpeg", 					"mpeg","mpg","mpe","m1s","m1v","m1a","m75","m15","mp2");
		new Type("video/quicktime", 				"mov","qt");		
	}
		
	
	/**
	 * @param ext - Extencion del documento seleccionado.
	 * @return El tipo Mime para la extencion 
	 * ingresada en Content Manager.
	 */
	public static String getMimeTypeByExt(String ext){
		String mime = null;
		if(ext != null){
			Type type = Type.extensiones.get(ext);
			if(type!=null){
				mime =type.getMime();
			}
		}
		 return mime;
	}
	
	/**
	 * @param url - Url del documento ingresado.
	 * @return El tipo Mime del documento 
	 * ingresado para Content Manager.
	 */
	public static String getMimeTypeByUrl(String url){
		String[] a = url.split("\\.");
		String ext = a.length > 0?a[a.length-1]:null;
		return getMimeTypeByExt(ext);	
	}

	private static final class Type{
		private static Map<String,Type> extensiones = new HashMap<String,Type>();;
		private static Collection<Type> mimes = new ArrayList<Type>();
		private String mime;
		
		public Type(String mime, String... exts) {
			this.mime = mime;
			for(String ext : exts){
				extensiones.put(ext, this);
			}
			mimes.add(this);
		}

		public String getMime() {
			return mime;
		}
	}	
}
