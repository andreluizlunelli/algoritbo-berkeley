package br.com.andreluizlunelli.algoritmo_berkeley;

import java.util.HashMap;

public class ParseReturn {
	public static final String VALUE_SEPARATOR = "%%";
	public static final String COLUMN_SEPARATOR = "&&";
	private String return_;
	private HashMap<String, String> params = new HashMap<String, String>();

	/**
	 * Formato esperado: chave:valor,
	 * @param return_
	 */
	public ParseReturn(String return_) {
		super();
		this.return_ = return_;
		parse();
	}
		
	public String getValue(String key) {
		return params.get(key);
	}
	
	private String[] internalSplitKeyValue(String paramStr) {
		String[] split = paramStr.split(VALUE_SEPARATOR);
		String[] keyValue = new String[2];
		int i = 0;
		try {
			keyValue[i] = split[i];
		} catch (ArrayIndexOutOfBoundsException e) {
			keyValue[i] = null;
		}
		i = 1;
		try {
			keyValue[i] = split[i];
		} catch (ArrayIndexOutOfBoundsException e) {
			keyValue[i] = null;
		}
		return keyValue;
	}

	public HashMap<String, String> parse() {
		String[] commaSplit = return_.split(COLUMN_SEPARATOR);
		for (String paramStr : commaSplit) {
			String[] split = internalSplitKeyValue(paramStr);			
			params.put(split[0], split[1]);
		}
		return params;		
	}
}
