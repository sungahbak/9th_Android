- Activity
    - Activity란 무엇인가요?

  앱을 켰을 때 바로 보이는 홈 화면, 필요에 따라 다른 창 위에 작게 띄울 수도 있다. ‘Kotlin(Java) 클래스 파일’과 ‘레이아웃 XML 파일’로 구성되어 있다. xml파일에서는 액티비티의 ui를 자유롭게 만들 수 있다.

  https://www.tosspayments.com/blog/articles/mobile-pay-2

  ![image.png](attachment:a8fd933c-ac23-4119-84b7-1f8dd3c8ef22:image.png)

- Activity-Layout 결합
    - findViewById
        - findViewById 사용법

          리소스 id를 통해서 레이아웃에 있는 뷰 객체들 중 일치하는 뷰를 가져오는 레거시방식

          하지만 그 전에 setContentView와 같은 메소드로 xml에 있는 리소스를 지정한 속성에 맞게 인스턴스를 생성하여 메모리에 로드하는 인플레이션 과정이 필요함

          메소드를 통해 뷰 객체를 하나씩 가져오게 되면 보일러 플레이트 코드들을 많이 생성하고 성능상으로도 안좋아서 대체방법등장

          https://velog.io/@ows3090/Android-findViewById-%EC%9B%90%EB%A6%AC

    - ViewBinding
        - ViewBinding 사용법

          각 xml 레이아웃 파일에 대해 고유한  바인딩 클래스를 자동으로 생성하는 기능, 레이아웃 내의 모든 뷰를 직접 참조하는 속성을 포함한다.

    - findViewById보다 ViewBinding이 권장되는 이유
        - findViewById의 단점

          수많은 뷰를 다룰 때 각 뷰마다 `findviewbyld` 를 호출해야 하므로 코드가 길어짐

          뷰가 없으면 `NullPointerException`이 발생할 수 있다.

          타입 캐스팅 필요

        - ViewBinding의 장점

          타입 안정성 : 널이 될 수 없는 참조를 직접 얻을 수 있어 `NullPointerException`을 방지
          코드 간소화 : `findViewById`를 호출할 필요 없이 바인딩 객체를 통해 바로 접근
          쉬운 구현 : 앱 수준에서 설정을 활성화 하면 자동으로 바인딩 클래스가 생성된다.

          https://developer.android.com/topic/libraries/view-binding?hl=ko

- 새 Activity를 띄우는 방법
    - Intent를 이용해 새 액티비티를 띄우는 방법은 무엇인가요?
        1. Intent객체 생성

           띄우고자 하는 액티비티를 명시적으로 지칭하는 intent객체를 생성한다.

            ```jsx
            Intent intent = new Intent(현재_액티비티.this, 띄울_액티비티.class);
            ```

        2. 액티비티 시작

           생성한 intent객체를 startActivity()메서드에 전달하여 새 액티비티를 시작한다.

            ```jsx
            startActivity(intent);
            ```

    - Activity간 데이터를 전달하려면 어떻게 해야 하나요?
- Fragment
    - Fragment란 무엇인가요?

      앱 UI의 재사용 가능한 부분, 자체 레이아웃을 정의 및 관리하고 자체 수명주기를 보유하며 자체 입력 이벤트를 처리할 수 있다. 단독으로 실행될 수 없음.


    https://developer.android.com/guide/fragments?hl=ko
    
    - Fragment를 사용하는 이유는 무엇인가요?
        
        코드 재사용성을 높이고 유연한 UI디자인을 구현하기 위해서
        
    - Fragment는 어떻게 하면 화면에 보이게 할 수 있나요?
        
        액티비티에 연결해 화면에 보이게 한다.

- FragmentManager
    - FragmentManager란 무엇인가요?

      앱 프래그먼트에서 프래그먼트를 추가, 삭제 또는 교체하고 백 스텍에 추가하는 등의 작업을 실행하는 클래스

    - FragmentManager는 언제 사용해야 될까요?
        1. 동적으로 프래그먼트 추가 및 제거할 때
        2. 프래그먼트 교체

            ```kotlin
            // FragmentTransaction 시작
            supportFragmentManager.beginTransaction()
            // 현재 프레임 레이아웃(R.id.fragment_container)에 FragmentB를 교체
            .replace(R.id.fragment_container, FragmentB())
            // 뒤로 가기 버튼을 눌렀을 때 이전 프래그먼트로 돌아가도록 백 스택에 추가
            .addToBackStack(null)
            // 트랜잭션 커밋
            .commit()
            ```

        3. 백 스택 관리
        4. 프래그먼트 간 통신
        5. 다양한 화면 크기에 대한 ui유연성
- Bundle
    - Bundle은 무엇일까요?

      Map형태로 여러가지의 타입의 값을 저장하는 클래스

    - Intent와 Bundle을 결합하는 방법은 무엇일까요?
        1. 데이터를 인텐트에 넣는 방법

            ```java
            // 새로운 인텐트 생성
            Intent intent = new Intent(this, TargetActivity.class);
            
            // putExtra()를 사용하여 데이터를 인텐트에 추가
            intent.putExtra("key_string", "Hello, World!");
            intent.putExtra("key_int", 123);
            intent.putExtra("key_boolean", true);
            
            // 액티비티 시작
            startActivity(intent);
            ```

        2. 번들을 직접 인텐트에 넣는 방법
            1. 데이터보내기

                ```java
                // 새로운 번들 객체 생성
                Bundle bundle = new Bundle();
                
                // putString(), putInt() 등을 사용하여 번들에 데이터 추가
                bundle.putString("user_name", "Alice");
                bundle.putInt("user_age", 25);
                bundle.putDouble("user_score", 95.5);
                
                // 새로운 인텐트 생성
                Intent intent = new Intent(this, TargetActivity.class);
                
                // putExtras()를 사용하여 번들을 인텐트에 추가
                intent.putExtras(bundle);
                
                // 액티비티 시작
                startActivity(intent);
                ```

            2. 데이터받기

                ```java
                // 인텐트 가져오기
                Intent receivedIntent = getIntent();
                
                // getStringExtra() 등을 사용하여 데이터 추출
                String receivedString = receivedIntent.getStringExtra("key_string");
                int receivedInt = receivedIntent.getIntExtra("key_int", 0); // 두 번째 인자는 기본값
                boolean receivedBoolean = receivedIntent.getBooleanExtra("key_boolean", false);
                
                // 데이터 활용 (예: 로그 출력 또는 UI 업데이트)
                Log.d("ReceivedData", "String: " + receivedString);
                Log.d("ReceivedData", "Int: " + receivedInt);
                Log.d("ReceivedData", "Boolean: " + receivedBoolean);
                ```

- BottomNavigationView란?
    - BottomNavigationView란 무엇이고, 어떤 기능을 하나요?

      화면 밑에 있는 네비게이션 역할을 하는 버튼 모음

      메뉴항목에 따라 화면을 전환하는 역할을 하고 각각의 버튼을 눌렀을 때 레이아웃에 fragment를 붙일 수 있다.

      https://velog.io/@abc9985/AndroidBottomNavigationView-%EB%A7%8C%EB%93%A4%EC%96%B4%EB%B3%B4%EA%B8%B0

- BottomNavigationView의 구성 요소
    - BottomNavigationView를 사용 시 추가 레이아웃을 정의해야 합니다. 이때 정의해야 할 요소들은 무엇인가요?

      menu파일과 fragment레이아웃

    - Menu 리소스 XML
        - <menu> 태그는 무엇일까요?

          현재 편집하고 있는 리소스가 menu라는 의미

        - <item> 태그는 무엇일까요?

          하단 네비게이션 바에서 전환될 화면에 대한 바로가기

        - <item> 태그에 설정할 수 있는 항목에는 무엇이 있을까요?

            ```java
            android:id: 항목을 고유하게 식별하는 ID입니다.
            
            android:icon: 항목에 표시될 아이콘입니다. 일반적으로 Drawable 리소스를 사용합니다.
            
            android:title: 항목에 표시될 텍스트입니다. @string/ 리소스를 사용하는 것이 좋습니다.
            ```

    - 화면 구성

      ![Untitled](attachment:3cf80661-4cea-48b2-b1b8-a432b34028db:Untitled.png)

        1. 왼쪽의 예시 화면에서 (A)와 (B)에 해당하는 각각의 알맞은 **화면 구성 요소**를 선택해주세요!
            - (A) = Activity
            - (B) = Fragment
        2. 왼쪽 화면을 구성하기 위해서 일반적으로 몇 개의 Fragment가 필요한가요??
            - 정답 ) 3개
- Naming Convention
    - 안드로이드 XML Naming Convention은 어떤 형식이 있을까요?
        - XML규칙

      XML 파일은 리소스 종류에 따라 다음과 같은 접두사를 사용하여 구분합니다.

        - **레이아웃 (Layout):** `activity_`, `fragment_`, `item_`, `dialog_` 등의 접두사를 사용합니다.
            - `activity_main.xml`
            - `fragment_detail.xml`
            - `item_list.xml`
        - **드로어블 (Drawable):** `ic_` (아이콘), `bg_` (배경) 등의 접두사를 사용합니다.
            - `ic_launcher_foreground.xml`
            - `bg_button_rounded.xml`
        - **애니메이션 (Animation):** `anim_` 접두사를 사용합니다.
            - `anim_fade_in.xml`
        - **값 (Values):** `dimens.xml`, `strings.xml`, `colors.xml`, `styles.xml`처럼 리소스 종류를 나타내는 단어를 사용합니다.
        - **뷰(View) ID 규칙**
        - **Button:** `btn_`
            - `btn_login`
        - **TextView:** `tv_` 또는 `text_`
            - `tv_username`
        - **ImageView:** `iv_` 또는 `img_`
            - `iv_profile_picture`
        - **EditText:** `et_` 또는 `edit_`
            - `et_password`
        - **RelativeLayout:** `rl_`
            - `rl_container`
        - **LinearLayout:** `ll_`
            - `ll_header`
        - **ConstraintLayout:** `cl_`
            - `cl_main`

      **속성(Attribute) 값 규칙**

      XML 속성(예: `android:text`, `android:layout_width`)에 할당하는 값은 다음과 같은 규칙을 따릅니다.

        - **문자열 (String):** `@string/` 리소스 참조를 사용하며, 문자열 리소스 이름은 `snake_case`를 사용합니다.
            - `@string/greeting_message`
        - **색상 (Color):** `@color/` 리소스 참조를 사용하며, 색상 이름은 `snake_case`를 사용합니다.
            - `@color/primary_blue`
        - **크기 (Dimension):** `@dimen/` 리소스 참조를 사용하며, 크기 이름은 `snake_case`를 사용합니다.
            - `@dimen/margin_small` 