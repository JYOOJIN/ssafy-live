//파일명: order.js
console.log("order.js loading...");
//alert("order.js loading");

let qty = prompt("주문수량을 입력하세요", "");
console.log(qty);

// 데이터 검증: 미입력, 공백입력, 문자 입력, 음수 입력, 숫자 입력
// 문자열 객체(string)  : 공백제거 trim(), 문자열 길이 lenght 변수(property)
if (parseInt(qty) <= 0 || qty == null || qty.trim().length == 0 || isNaN(qty)) {
  alert("오류: 주문 수량은 숫자를 필수로 입력해주세요.");
} else {
  let price = 5000;
  let orderPrice = qty * price;

  let info = ""; //명시적 공백 문자열 초기화하지 않으면 undefined
  info += "상품가격: ";
  info += price;
  info += "원\n";

  info += "주문 수량: ";
  info += qty;
  info += "개\n";

  info += "주문금액: ";
  info += orderPrice;
  info += "원\n";

  info += "주문을 하시겠습니까?";

  let isOrder = confirm(info);

  //dom 사용하기
  let qty_viewElement = document.getElementById("qty_view"); //<body>...</body>
  let price_viewElement = document.querySelector("#price_view");

  if (isOrder) {
    alert("상품 주문 완료");
    qty_viewElement.innerHTML = qty;
    price_viewElement.innerHTML = orderPrice;

    //element style css 적용
    //property-name 단일 단어는 그대로 사용
    //font-weight => fontWeight
    //font-size => fontSize
    //color => color
    price_viewElement.style.color = "red";
    price_viewElement.style.fontWeight = "bold";
  } else {
    alert("상품 주문 취소");
  }
}
