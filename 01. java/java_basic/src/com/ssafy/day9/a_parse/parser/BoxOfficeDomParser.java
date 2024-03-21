package com.ssafy.day9.a_parse.parser;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.ssafy.day9.a_parse.dto.BoxOffice;

public class BoxOfficeDomParser implements BoxOfficeParser {

    private static BoxOfficeDomParser parser = new BoxOfficeDomParser();

    public static BoxOfficeDomParser getParser() {
        return parser;
    }

    private BoxOfficeDomParser() {
        System.out.println("DOM parser");
    }

    private List<BoxOffice> list;

    @Override
    public List<BoxOffice> getBoxOffice(InputStream resource) {
        list = new ArrayList<>();
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            // 문서 로딩 완료 --> 원하는 요소들 골라내기
            Document doc = builder.parse(resource);
            // 최 상위 element
            Element root = doc.getDocumentElement();
            parse(root);
        } catch (IOException | ParserConfigurationException | SAXException e) {
            e.printStackTrace();
        }
        return list;
    }

    private void parse(Element root) {
        // TODO: root에서 dailyBoxOffice를 추출한 후 BoxOffice를 생성해 list에 저장하시오.
    	NodeList list = root.getElementsByTagName("dailyBoxOffice");
    	for(int i = 0; i < list.getLength(); i++) {
    		Node child = list.item(i);
    		BoxOffice bo = getBoxOffice(child);
    		this.list.add(bo);
    	}
        // END
    }

    private static BoxOffice getBoxOffice(Node node) {
        BoxOffice boxOffice = new BoxOffice();
        // TODO: node 정보를 이용해서 BoxOffice를 구성하고 반환하시오.
        NodeList subNodes = node.getChildNodes();
        for(int i = 0; i < subNodes.getLength(); i++) {
        	Node sub = subNodes.item(i);
        	if(sub.getNodeName().equals("rank")){
        		boxOffice.setRank(Integer.parseInt(sub.getTextContent()));
        	}else if(sub.getNodeName().equals("movieNm")) {
        		boxOffice.setMovieNm(sub.getTextContent());
        	}else if(sub.getNodeName().equals("openDt")) {
        		boxOffice.setOpenDt(boxOffice.toDate(sub.getTextContent()));
        	}else if(sub.getNodeName().equals("audiAcc")) {
        		boxOffice.setAudiAcc(Integer.parseInt(sub.getTextContent()));
        	}
        }
        // END
        return boxOffice;
    }
}
