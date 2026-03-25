package http.api;




public class response {
    Body body;
    Header header;


}

class Body{
    int totalCount;
    Items items;
    int pageNo;
    int numOfRows;

}

class Items {
    String clearVal;
    String sn;
    String districtName;
    String dataDate;
    String issueVal;
    String issueTime;
    String clearDate;
    String issueDate;
    String moveName;
    String clearTime;
    String issueGbn;
    String itemCode;

}

class Header {
    String resultMsg;
    String resultCode;
}


