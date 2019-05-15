# Fulfillment Service (창고 시스템)

프로젝트 기간 : 19/04/30 ~ 19/05/17

jstl, servlet을 활용한 창고 관리 홈페이지 개발



## 목차

- [요구사항](#요구사항)
- [DB 설계 테이블](#db-설계-테이블)
- [포함된 파일](#포함된-파일)
- [Demo 영상](#demo-영상)
- [공동 제작자](#공동-제작자)


## 요구사항

1. 귀하는 귀하 소유의 창고를 이용하여 풀필먼트 서비스(Fulfillment Service)를 하고자 한다. 
2. 귀하는 3개 이상의 쇼핑몰, 4개의 운송회사(경기, 중부, 영남, 서부물류) 및 5개 이상의 구매처와 거래하고 있다.
3. 쇼핑몰로부터는 송장을 CSV 형태로 받아서 처리한다. 송장에는 받는 사람의 이름, 전화번호, 주소와 배달할 품목의 제품코드, 제품명, 수량이 들어가 있다.
4. 전일 오후 6시부터 금일 오전 9시까지의 주문은 오전 9시에 처리하고, 금일 오전 9시부터 오후 6시까지의 주문은 오후 6시에 처리한다. 처리해야 할 것은 운송회사의 트럭에 운송지 별로 화물을 적재하고 송장을 운송회사에 전달하는 것이다. (출고)
5. 창고에 보관되어 있는 물품은 최소한 30가지 이상이어야 하고, 물품을 관리하기 위해서 물품의 ID, 물품명, 사진, 개별가격, 재고수량을 보관하여야 한다.
6. 재고수량이 10개 미만으로 떨어지는 순간 구매처에 발주를 하여야 하고, 구매처는 발주한 다음날 오전 10시에 납품을 한다. (입고) 재고수량이 모자라면 운송을 할 수 없다.
7. 관리자는 언제든지 창고의 재고를 파악할 수 있어야 하고(재고조사), 영업을 위해서 창고에서 보관하고 있는 물품을 사진을 포함하여 잠재 고객에게 보여줄 수 있어야 한다.
8. 매월 단위로 쇼핑몰에 대금을 청구하는데, 청구 금액은 물품 가격과 물품 가격의 10%에 해당하는 서비스료 및 1개의 송장당 10,000원이다. 구매처와 운송회사에는 매월 단위로 물품 가격과 운송비를 지급한다.
9. 관리자는 월 단위로 판매 내역, 발주 내역, 운송 내역 및 매출 총이익을 알 수 있어야 한다. 구매처와 운송회사는 시스템에 로그인해서 일별/월별 주문내역을 확인할 수 있어야 한다.



## DB 설계 테이블
 
 ![database.png](/database.png)



## 포함된 파일

```text
FulfillmentService/
├── src/
│  ├── CalculateCostDAO.java
│  ├── CalculateCostDTO.java
│  ├── CalculateCostProc.java
│  ├── EventDTO.java
│  ├── FileDAO.java
│  ├── FileProc.java
│  ├── InvoiceDAO.java
│  ├── InvoiceDTO.java
│  ├── LoginProc.java
│  ├── OrderCompanyDAO.java
│  ├── OrderCompanyDTO.java
│  ├── ProductDAO.java
│  ├── ProductDTO.java
│  ├── ProductProc.java
│  ├── TransCompanyDAO.java
│  ├── TransCompanyDTO.java
│  └── log4j.xml
└── WebContent/
    ├── Resources/
    │  ├── css/
    │  │  ├── bootstrap-theme.css
    │  │  ├── bootstrap-theme.css.map
    │  │  ├── bootstrap-theme.min.css
    │  │  ├── bootstrap.css
    │  │  ├── bootstrap.css.map
    │  │  ├── bootstrap.min.css
    │  │  ├── invoiceProcessDetail.css
    │  │  ├── jquery-ui.min.css
    │  │  ├── login.css
    │  │  └── topbutton.css
    │  ├── fonts/
    │  │  └── ...
    │  ├── img/
    │  │  └── ...
    │  └── js/
    │  │  ├── bootstrap.js
    │  │  ├── bootstrap.min.js
    │  │  ├── jquery-ui.min.js
    │  │  └── npm.js
    ├── common/
    │  ├── cHeader.jsp
    │  ├── cNavigator.jsp
    │  ├── footer.jsp
    │  ├── header.jsp
    │  └── navigator.jsp
    └── view/
        ├── cDailyOrderHistory.jsp
        ├── cLoginMain.jsp
        ├── cMonthlyOrderHistory.jsp
        ├── checkInventory.jsp
        ├── checkInventoryDetail.jsp
        ├── index.jsp		<---- Main
        ├── invoiceProcess.jsp
        ├── invoiceProcessDetail.jsp
        ├── login.jsp
        ├── loginMain.jsp
        ├── monthlyOrderHistory.jsp
        ├── monthlySalesHistory.jsp
        ├── monthlyTransitHistory.jsp
        ├── orderRequest.jsp
        ├── orderRequestDetail.jsp
        └── totalSales.jsp
```


## Demo 영상

- <https://youtu.be/KAKG0QVIzzk>



## 공동 제작자

- <http://github.com/JungHwaJung>
- <http://github.com/kjh0202>

