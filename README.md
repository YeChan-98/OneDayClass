<h1 align='center'> <img src='https://github.com/user-attachments/assets/07cb2a44-7404-46de-a9ba-d309942dcd4f' style='width: 300px; height: 200px;'>&nbsp;</h1>
<h1  align='center'>원 데이 클래스</h1>
<div align='center'>
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

  

## 프로젝트 설계, 구현 PPT



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
  * 메인페이지는 로그인, 회원가입, 클래스 추천, 클래스 목록으로 이동하는 버튼이 있음.
    
    ![mainpage](https://github.com/user-attachments/assets/07cb2a44-7404-46de-a9ba-d309942dcd4f)

* **로그인**
  * 로그인, 회원가입 설명.

## 🌄 개선사항 <a id="chapter6"></a>
- 카카오, 네이버 등 소셜 로그인 기능
- 클래스 예약 완료 및 승인/거절 시 확인 메일 발송 기능
- 관리자의 회원 관리 기능
- 클래스 등록 파일 업로드 기능
