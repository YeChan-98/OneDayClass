<h1 align='center'> <img src='https://github.com/user-attachments/assets/07cb2a44-7404-46de-a9ba-d309942dcd4f'>&nbsp;</h1>
<h1  align='center'>원 데이 클래스</h1>
<br/><br/>


## 목차
- [개요](#chapter1)
- [기술 스택](#chapter2)
- [프로젝트 설계](#chapter3)
- [핵심 기능](#chapter4)
- [주요기능 실행화면](#chapter5)
- [개선사항](#chapter6)
  


## 개요 <a id="chapter1"></a>
- 프로젝트 목표 : 다양한 `API`를 활용한 `스프링` , `마이바티스` 원 데이 클래스 프로젝트
- 개발기간 : 24/11/25 ~ 24/12/13



## 기술 스택 <a id="chapter2"></a>
- API : `카카오맵 API` `PortOne API` 
- Language : `Java(11)` `JavaScript(1.5)`
- Library & Framework : `Spring(5.2.7)` `Junit(4.12)` `Servlet(3.1.0)` `Spring Security`
- Database : `MySQL(8.0.35)`, `Oracle IDE(17.2.0)`
- Target : `Web Browser`
- Tool : `SpringSource Tool Suite (STS) 3.9.18.RELEASE`
- Infra : `Windows10`
- Etc : `Git`

  

## 프로젝트 설계, 구현 PPT(ERD, USECASE)



<details><summary>프로젝트 설계, 구현, PPT</summary> <a id="chapter3"></a>   
<div align="center">          

| **![슬라이드1](https://github.com/user-attachments/assets/5ae9b15c-6182-4adc-a24a-5195065b0713)** | **![슬라이드2](https://github.com/user-attachments/assets/9d2ce666-d303-4329-a41b-104b9f46bedd)** |
| :------: | :------: |
| ![슬라이드3](https://github.com/user-attachments/assets/87c89ec5-9c25-467c-b898-1449d8ed9d57) | ![슬라이드4](https://github.com/user-attachments/assets/256e9521-192f-427e-b76c-6242e4368297) |
| ![슬라이드5](https://github.com/user-attachments/assets/a7ec4d2d-738b-4c37-93b4-1f084933057b) | ![슬라이드6](https://github.com/user-attachments/assets/6e0bbc1d-629e-4698-bbee-4921ab0d925f) |
| ![슬라이드7](https://github.com/user-attachments/assets/e3dfa277-92dc-4e07-b695-fa4a67fd683f) | ![슬라이드8](https://github.com/user-attachments/assets/139dc334-bf9d-4aef-af25-ca64761edc21) |
| ![슬라이드9](https://github.com/user-attachments/assets/1532467d-000b-4685-9299-ee191969b81b) | ![슬라이드10](https://github.com/user-attachments/assets/47a5db38-1aa8-4a3c-9657-d964eb175b3d) |
| ![슬라이드11](https://github.com/user-attachments/assets/a0aa60cb-81a3-40d2-b3d6-d676f02f5a84) | ![슬라이드12](https://github.com/user-attachments/assets/b8bae6d5-df59-429d-ba1d-716482f4469d) |
| ![슬라이드13](https://github.com/user-attachments/assets/e2017507-fde4-4752-8052-a030bef4c381) | ![슬라이드14](https://github.com/user-attachments/assets/a5b83b30-8cc8-46cc-9e6d-94351303fa49) |
| ![슬라이드15](https://github.com/user-attachments/assets/0cce8ab2-b406-4373-840e-734a9f253f9a) | ![슬라이드16](https://github.com/user-attachments/assets/10728f08-ac9d-4e3d-b120-b40fb686927c) |
| ![슬라이드17](https://github.com/user-attachments/assets/e14edb60-0703-4cab-a1a7-9c942d79af59) | ![슬라이드18](https://github.com/user-attachments/assets/ed693cfd-0969-41dc-880e-6f099d0679c7) |
| ![슬라이드19](https://github.com/user-attachments/assets/60f7a1e1-0125-4aeb-b2d4-9d40bfc83441) | ![슬라이드20](https://github.com/user-attachments/assets/340ee652-dec7-4d74-92f7-1ed66a86928f) |
| ![슬라이드21](https://github.com/user-attachments/assets/d2dda30c-d8c4-4b49-8027-5890919d24a9) | ![슬라이드22](https://github.com/user-attachments/assets/465c97d2-be17-474f-b08c-a96be011628b) |
| ![슬라이드23](https://github.com/user-attachments/assets/33762fee-584a-465c-a546-6420f8767fd5) | ![슬라이드24](https://github.com/user-attachments/assets/dad2e0d6-d9b3-4347-b60c-4dbe014b6444) |
| ![슬라이드25](https://github.com/user-attachments/assets/70f38829-1194-4b42-b82a-5ea0bf66c4e4) | ![슬라이드26](https://github.com/user-attachments/assets/7b880101-36df-4907-9270-1600bcd29aba) |
| ![슬라이드27](https://github.com/user-attachments/assets/5a095f79-5be7-4695-960e-e9b8653a838b) | ![슬라이드28](https://github.com/user-attachments/assets/351a49b1-228b-4d42-a758-3b260cd6bafd) |
| ![슬라이드29](https://github.com/user-attachments/assets/a347ee10-351d-4af2-9b57-10647a824b0c) | ![슬라이드30](https://github.com/user-attachments/assets/bf3dbe8f-f74d-4841-bcfa-f6b5674ca017) |
| ![슬라이드31](https://github.com/user-attachments/assets/3a9d6c83-99d3-4aeb-a3e2-2e9e44bf2f9d) | ![슬라이드32](https://github.com/user-attachments/assets/936bc528-d55d-4113-961d-fc62877e6854) |
| ![슬라이드33](https://github.com/user-attachments/assets/751cabca-fd5f-453e-bd54-57fccece2b63) | ![슬라이드34](https://github.com/user-attachments/assets/68a2493f-3087-4faf-9605-90ff7b3c390f) |
| ![슬라이드35](https://github.com/user-attachments/assets/0ca7c33d-93d5-4243-8cbd-70ac78b0715c) | ![슬라이드36](https://github.com/user-attachments/assets/c0e1a2b0-735d-400c-a69d-737c497b022f) |
| ![슬라이드37](https://github.com/user-attachments/assets/95cdcabb-ef02-424e-87dd-7765fbfaa0b7) | ![슬라이드38](https://github.com/user-attachments/assets/f21311e1-b3f0-4a72-8c1f-ca99b9125e5b) |
| ![슬라이드39](https://github.com/user-attachments/assets/d055e657-5ba4-4de5-bfd3-4863eb3de787) | ![슬라이드40](https://github.com/user-attachments/assets/283606c5-c07a-4593-a6b3-f2ca6f14e76d) |
| ![슬라이드41](https://github.com/user-attachments/assets/ecc18ece-403c-4a85-9abd-a4748b8a7ab3) | ![슬라이드42](https://github.com/user-attachments/assets/6b4c6c90-5069-489b-8add-b00c59297c69) |
| ![슬라이드43](https://github.com/user-attachments/assets/673994bf-157d-47e1-a50d-4c2c9e9ea98d) | 

</div>            
</details>

## 핵심 기능 <a id="chapter4"></a>

#### 로그인
- 시큐리티 로그인
- 회원가입(아이디 중복체크, 비밀번호 암호화 인코딩)
- 아이디 찾기
- 비밀번호 초기화

#### 클래스 리스트
- 클래스 검색(카테고리, 제목 키워드 검색)

#### 클래스 상세
- 클래스 상세
- 클래스 일정 선택
- 클래스 위치 및 지도(카카오맵 API)
- 클래스 후기
- 클래스 문의

#### 클래스 예약
- 클래스 예약 및 결제(PortOne API)

#### 클래스 추천
- 선택의 따른 클래스 추천

#### 마이페이지 
- 회원정보 보기
- 회원정보 수정하기

#### 예약/리뷰
- 예정된 클래스
- 완료된 클래스
- 리뷰 작성
- 리뷰 수정/삭제

#### Q&A 
- 미답변 문의
- 답변완료 문의
- 문의 삭제

#### 관리자
- 클래스 등록하기(스케줄 추가하기)
- 클래스 수정/삭제
- 예약 승인 예정
- 예약 승인 거절
- 예약 승인 완료
- 문의 미답변
- 문의 답변완료

 
## 주요기능 실행화면 <a id="chapter5"></a>


* **메인 화면**
    
![mainpage](https://github.com/user-attachments/assets/07cb2a44-7404-46de-a9ba-d309942dcd4f)
  * 메인페이지는 로그인, 회원가입, 클래스 추천, 클래스 목록으로 이동하는 버튼으로 구성되어 있습니다.

<br><br>
* **로그인 및 회원가입**
![Login](https://media.githubusercontent.com/media/YeChan-98/OneDayClass/refs/heads/main/gif/login.gif)
  * 로그인 및 회원가입 시연.

<br><br>
* **로그인**

![Login]( https://media.githubusercontent.com/media/YeChan-98/OneDayClass/refs/heads/main/gif/396338413-84282530-06a4-4379-8dd4-acdb723b5d93.gif)
  * 아이디 또는 비밀번호를 입력하지 않고 로그인 버튼을 클릭할 경우, 미입력된 정보를 입력하라는 메시지가 표시됩니다. <br><br>

![Login]( https://media.githubusercontent.com/media/YeChan-98/OneDayClass/refs/heads/main/gif/396357669-de45ed1c-93f0-4a2f-aebf-d7195f724967.gif)
  * 입력한 회원정보와 일치하는 아이디 찾기 및 비밀번호 초기화 기능을 제공합니다.

<br><br>
* **회원가입**

![Login]( https://media.githubusercontent.com/media/YeChan-98/OneDayClass/refs/heads/main/gif/396337643-7d89fd5e-7263-4454-9eeb-3fa09d4b2c42.gif)
  * 비밀번호와 비밀번호 확인란의 값이 다를 경우, '비밀번호가 일치하지 않습니다.'라는 경고창이 출력됩니다.
  * 아이디 중복 체크를 수행하지 않은 경우, '중복 체크가 이루어지지 않았습니다.'라는 경고창이 표시됩니다.
  * 아이디 중복 체크 버튼 클릭 시, 사용 가능 여부에 따라 '이 아이디는 사용 중입니다.' 또는 '사용 가능한 아이디입니다.'라는 결과창이 출력됩니다.

<br><br>
* **클래스 리스트/검색**

![Login](https://media.githubusercontent.com/media/YeChan-98/OneDayClass/refs/heads/main/gif/search.gif)
  * 카테고리를 선택하거나 키워드를 입력하여 검색할 수 있으며, 두 가지 방법을 함께 활용할 수도 있습니다.

<br><br>
* **클래스 상세페이지**

![Login](https://github.com/YeChan-98/OneDayClass/raw/refs/heads/main/gif/detail.gif)
  * 선택된 클래스의 상세 설명과 함께 카카오 지도 API를 사용하여 마커로 장소를 표시하고 있습니다.<br><br>

![Login](https://github.com/YeChan-98/OneDayClass/blob/main/gif/396324237-b1929659-c319-4654-be9e-d3fbfcf27e5e.gif)
  * 해당 클래스의 후기(리뷰)게시판과 QnA게시판을 페이징 되어 있는 상태로 볼 수 있습니다. <br><br>

![Login](https://media.githubusercontent.com/media/YeChan-98/OneDayClass/refs/heads/main/gif/396324405-b0bec65c-ec81-483e-af78-fe328da01281.gif)
  * 로그인된 회원에게는 문의하기 버튼이 제공됩니다. 버튼을 클릭하면 모달 창을 통해 문의사항을 입력하고 등록할 수 있습니다.

<br><br>
* **클래스 예약**

![Login](https://media.githubusercontent.com/media/YeChan-98/OneDayClass/refs/heads/main/gif/pay.gif)
  * 원하는 일정과 수강인원을 선택하여 클래스를 예약할 수 있습니다.
  * 로그인이 되어 있지 않은 상태에서 클래스 예약 버튼을 클릭하면, 로그인을 안내하는 경고창이 나타납니다.<br><br>

![Login](https://media.githubusercontent.com/media/YeChan-98/OneDayClass/refs/heads/main/gif/paying.gif)
  * 예약 확인(결제) 페이지에서는 선택한 정보를 확인하고 결제를 진행할 수 있습니다.

<br><br>
* **클래스 추천**

![Login](https://media.githubusercontent.com/media/YeChan-98/OneDayClass/refs/heads/main/gif/396339950-b0a28948-0b35-4851-abbf-e87e55b08215.gif)
  * 준비된 네 가지 질문에 해당하는 답변을 선택하면, 그에 맞는 클래스를 자동으로 추천해드립니다.

<br><br>
* **마이페이지**

![Login](https://media.githubusercontent.com/media/YeChan-98/OneDayClass/refs/heads/main/gif/396340134-4f1b0d8c-a9d7-4387-aa0c-96654fa1ba53.gif)
  * 회원정보 확인 및 수정하기.

<br><br>
* **예약/리뷰**

![Login](https://media.githubusercontent.com/media/YeChan-98/OneDayClass/refs/heads/main/gif/396377219-8a2b8829-c8b1-401d-aacf-332d55cc3157.gif)
  * 예약/리뷰 페이지에서는 나의 예약 정보를 '예정된 클래스'와 '완료된 클래스'로 구분하여 확인할 수 있습니다. '예정된 클래스'에서는 결제 취소 버튼을 통해 예약을 취소할 수 있으며, '완료된 클래스'에서는 리뷰를 작성하거나 이미 작성한 리뷰를 수정 및 삭제할 수 있습니다.

<br><br>
* **Q&A**

![Login](https://media.githubusercontent.com/media/YeChan-98/OneDayClass/refs/heads/main/gif/396349337-137fb1c1-cabb-4f94-9ec6-cd78500ec6db.gif)
  * Q&A 페이지에서는 나의 문의 내역을 '미답변'과 '답변 완료'로 구분하여 확인할 수 있습니다.

<br><br>
* **관리자페이지**

![Login](https://media.githubusercontent.com/media/YeChan-98/OneDayClass/refs/heads/main/gif/%ED%81%B4%EB%9E%98%EC%8A%A4%EB%93%B1%EB%A1%9D.gif)
  * 관리자로 로그인한 후 클래스 검색 페이지로 이동하면 '클래스 등록하기' 버튼이 활성화됩니다. 필요한 정보를 입력하여 새로운 클래스를 등록할 수 있습니다.<br><br>

![Login](https://media.githubusercontent.com/media/YeChan-98/OneDayClass/refs/heads/main/gif/396349345-f80404c2-1531-40fc-8e57-7c8e34c18af7.gif)
  * 클래스 상세 페이지로 이동하면 클래스의 '수정' 및 '삭제' 버튼이 활성화됩니다. '수정' 버튼을 클릭하면 클래스 수정 페이지에서 필요한 정보를 수정할 수 있으며, '삭제' 버튼을 클릭하면 클래스 삭제 경고창이 나타납니다.<br><br>

![Login](https://media.githubusercontent.com/media/YeChan-98/OneDayClass/refs/heads/main/gif/396363626-e9a7c1da-77fe-49a5-bae5-8596a4e13a45.gif)
  * 예약 관리 페이지에서는 내 클래스에 예약된 내역을 '승인 예정', '승인 거절', '승인 완료'로 구분하여 확인할 수 있습니다. '승인 예정' 목록에서는 '승인' 또는 '거절' 버튼을 사용해 승인 여부를 선택할 수 있으며, 선택된 내역은 자동으로 해당 목록으로 이동합니다.<br><br>

![Login](https://media.githubusercontent.com/media/YeChan-98/OneDayClass/refs/heads/main/gif/%EA%B4%80%EB%A6%AC%ED%8E%98%EC%9D%B4%EC%A7%80%EB%AC%B8%EC%9D%98%EB%8B%B5%EB%B3%80.gif)
  * Q&A 관리 페이지에서는 내 클래스에 들어온 문의 내역을 '미답변'과 '답변 완료'로 구분하여 확인할 수 있습니다. '미답변' 목록의 문의 내역에서는 '답변 달기' 버튼을 통해 답변을 등록할 수 있으며, 답변 등록과 동시에 '답변 완료' 목록으로 자동으로 이동합니다.

<br><br>
## 개선사항 <a id="chapter6"></a>
- 카카오, 네이버 등 소셜 로그인 기능
- 클래스 예약 완료 및 승인/거절 시 확인 메일 발송 기능
- 관리자의 회원 관리 기능
- 클래스 등록 파일 업로드 기능
