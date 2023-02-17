# AA_B1_G6_VideoRental
AA_B1차_6조 아키텍처 재설계 실습 VideoRental

1	VRUI	returnVideo()	Duplicate Code	clearRentals 의 Customer 를 확인하는 method 가 동일한 중복코드이다.

2	VRUI	rentVideo(),clearRentals()	Encapsulate Collection	

1	Customer 	getReport	"Long Method
(함수 추출)"	"getReport에 함수 길이가 길고 그 안에 여러가지 동작들을 진행하여서 
함수를 추출하는 작업 진행 : 렌트 날짜, 비용 계산 함수, 포인트 계산 
함수, 무료 쿠폰 조회 함수 생성"

3	Customer 	"getDaysRented
(신규 함수)"	dulicate code	"렌트일을 계산 부분에 if/else에 동일한 중복코드가 있어야 조건문 밖으로 
추출 - 연산부 수정시 한 군데 코드만 수정하면 됨
(daysRented = (int) (diff / (1000 * 60 * 60 * 24)) + 1)"

5	Customer 	"getDaysRented
(신규 함수)"	dulicate code	"getRentDate().getTime(); 이 중복되서 호출
변수로 rentDate에 저장"

6	VRUI	register	SRP 위반 register method 분리	
