- 플랫폼
    
    서로 다른 두 그룹 이상의 참여자들이 특정 가치를 교환하고 거래할 수 있도록 만들어진 환경이나 기반 시스템 
    
    안드로이드 플랫폼 - os + 시스템 소프트웨어
    
    1. os : 리눅스 커널을 기반으로
- Android의 Architecture
    - 안드로이드의 권장 아키텍쳐는 무엇일까요?
        - Jetpack 앱 아키텍쳐(클린 아키텍쳐)
            1. UI레이어 : 앱의 애플리케이션 데이터를 표시, 사용자 상호작용의 기본 역할
            2. 도메인레이어 : 앱의 핵심 비즈니스 로직을 캡슐화하여 재사용 가능하게
            3. 데이터레이어 : 앱의 데이터를 관리하고 제공, 필요하다면 네트워크 요청, 로컬 데이터베이스 접근 처리
            4. 
            
            ![image.png](attachment:3f0afd83-3e88-46f2-b757-750e4a45a8d3:image.png)
            
        - https://developer.android.com/topic/architecture/recommendations?hl=ko
        - https://developer.android.com/topic/architecture?hl=ko
    - 안드로이드 아키텍쳐 컴포넌트 (AAC)는 무엇일까요?
        - 안드로이드는 여러 컴포넌트들이 있고 생명주기가 다르게 얽혀있어 앱을 잘 만들기 위해서는 이러한 컴포넌트들을 부드럽게 연결해야 하는데 이를 학습하는 것은 개발자의 몫이였다. 이러한 문제를 해결하기 위해 안드로인드 앱을 위한 아키텍처를 정의하고 이를 구현하기 위한 라이브러리를 제공하고자 아키텍쳐 컴포넌트를 공개하였다.
        1. databinging
        2. lifecycle
        3. navigation
        4. room
        5. paging
        6. workmanager
        7. livedata
        8. viewmodel
            - https://velog.io/@alsgk721/%EC%95%88%EB%93%9C%EB%A1%9C%EC%9D%B4%EB%93%9C-25-Android-Architecture-Components-AAC
- Android의 4대 컴포넌트
    1. Activity : 사용자에게 실제로 보이는 화면, 액티비티에 프래그먼트를 추가하여 화면을 분할시킬 수 있다.
    2. Service : background에서 동작하는 컴포넌트
    3. Broadcast receiver : os로 부터 발생하는 각종 이벤트와 정보를 받아 핸들링하는 컴포넌트 , ui를 가지지 않는다.
    4. Content provider : 데이터를 관리하고 다른 앱의 데이터를 제공하는데 사용되는 컴포넌트 
    5. https://superohinsung.tistory.com/54
- Manifest의 주요 속성 (AndroidManifest.xml 참고!)
    - **패키지 이름 (Package Name)**: 앱의 고유 식별자
    - **진입점 (Entry Point)**: 앱이 시작되는 지점
    - **구성 요소 (Components)**: `Activity`, `Service`, `ContentProvider`, `BroadcastReceiver` 등 앱을 구성하는 요소들
    - **권한 (Permissions)**: 앱이 하드웨어(카메라, GPS 등)나 사용자 데이터에 접근하기 위해 필요한 권한
    - **메타데이터 (Metadata)**: 앱에 대한 추가적인 정보.
- Android 위젯&속성
    1. **Button**
        - 상호작용할수 있는 버튼
    2. **TextView**
        - 텍스트를 표현
    3. **ScrollView**
        - 스크롤 가능한 뷰를 표현 - 수직만 가능하다
    4. **BottomNavigationView**
        - 하단 네비게이션을 표현
    5. **ConstrainLayout**
        - 다른 위젯이나 부모의 레이아웃의 가장자리에 상대적으로 연결하여 위치와 크기를 지정하는 속성
    6. **chainStyle**
        - constrainlayout에서 사용하는 기능으로 양방향 체인으로 부모 ui와 자식ui의 요소를 설정한다.
    7. **Barrier**
        - 여러 뷰의 영역을 기준으로 삼아 "장벽"처럼 작용하여, 다른 뷰들이 특정 위치를 침범하지 않도록 하는 동적인 제약 조건
    8. **GuideLine**
        - constraintlayout에서 뷰를 배치할 때 기준선을 잡아주는 보이지 않는 선
    9. **margin**
        - 뷰 외부의 여백공간
    10. **padding**
        - 뷰 내부의 여백공간
    11. **id 네이밍 (android:id)**
        - 별명을 설정해주는것
- Intent
    - Intent의 역할은 무엇인가요?
        - 4대 컴포넌트를 실행하기 위한 시스템과 앱의 메세지 교환에서 사용
    - 명시적 Intent와 암시적 Intent의 차이는 무엇인가요?
        - 실행하고자 하는 대상이 명확할때 명시적 인텐트, 달라질수 있을때 암시적 인텐트
