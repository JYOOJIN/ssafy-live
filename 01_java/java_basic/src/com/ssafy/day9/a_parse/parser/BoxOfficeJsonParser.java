package com.ssafy.day9.a_parse.parser;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ssafy.day9.a_parse.dto.BoxOffice;

public class BoxOfficeJsonParser implements BoxOfficeParser {

    private static BoxOfficeJsonParser parser = new BoxOfficeJsonParser();

    public static BoxOfficeJsonParser getParser() {
        return parser;
    }

    private BoxOfficeJsonParser() {
        System.out.println("json");
    }

    private List<BoxOffice> list;

    @Override
    public List<BoxOffice> getBoxOffice(InputStream resource) {
        list = new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper();

        // 날짜 변경과 관련된 룰 지정
        mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd"));

        // TODO: json을 파싱해서 list를 구성하시오.
        try {
			Map<String, Map<String, Object>> result = mapper.readValue(resource, Map.class);
			List<Map<String, Object>> list = (List)result.get("boxOfficeResult").get("dailyBoxOfficeList");
        
			for(Map<String, Object> info : list) {
				BoxOffice office = mapper.convertValue(info, BoxOffice.class);
				this.list.add(office);
			}
        } catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        
        
        // END
        return list;
    }
}
