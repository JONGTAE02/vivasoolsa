package org.example.visang_vivasoolsa;

import lombok.RequiredArgsConstructor;
import org.example.visang_vivasoolsa.entity.Belief;
import org.example.visang_vivasoolsa.entity.Fortune;
import org.example.visang_vivasoolsa.repository.BeliefRepository;
import org.example.visang_vivasoolsa.repository.FortuneRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class DataInit implements CommandLineRunner {

    private final BeliefRepository beliefRepository;
    private final FortuneRepository fortuneRepository;

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        if (beliefRepository.count() > 0) {
            return;
        }

        System.out.println("초기 데이터 적재 시작...");

        // 1. 당연한 것도 낯설게 본다
        Belief belief1 = new Belief(
                "당연한 것도 낯설게 본다",
                "남들이 보지 못하는 새로운 관점을 제시한다."
                +"일을 할 때 일의 목적부터 명확히 정의한다.",
                "/images/card_belief_1.png"
        );
        beliefRepository.save(belief1);

        saveFortune(belief1,
                "같은 자리를 맴돌던 생각에 새로운 바람이 불 거예요.",
                "점심 시간에 평소 안 고르던 메뉴 하나 골라보기",
                "민트");
        saveFortune(belief1,
                "시작을 돌아보면 목적지가 선명해집니다.",
                "지금 하고 있는 일의 처음 이유를 한 문장으로 적어보기",
                "연필");
        saveFortune(belief1,
                "익숙함 속 새로움을 발견하는 하루예요.",
                "매일 하던 업무 중 하나를 다른 순서로 처리해보기",
                "체크무늬 메모지");
        saveFortune(belief1,
                "남들은 마침표를 찍을 때 당신은 물음표를 던지는 하루입니다.",
                "회의 or 대화에서 “왜 이렇게 해 왔을까요?” 질문 던지기",
                "물음표 스티커");

        // 1-5
        saveFortune(belief1,
                "깎이지 않은 돌에 진짜 보석이 있습니다.",
                "평소 대충 넘기던 자료를 30초만 더 살펴보기",
                "파란색 펜");


        // 2. 내가 즐기면서 하는 일이 우리를 성장시킨다
        Belief belief2 = new Belief(
                "내가 즐기면서 하는 일이 우리를 성장시킨다",
                "긍정적인 마음으로 새로운 시도를 즐긴다." + "일을 통해 배우고 성장하는 기쁨을 느낀다.",
                "/images/card_belief_2.png"
        );
        beliefRepository.save(belief2);

        saveFortune(belief2, "마음이 이끄는 대로 즐기는 하루에요.",
                "오늘 할 일 중 가장 끌리는 것부터 시작하기",
                "휴게실 안마의자");
        saveFortune(belief2, "몰입이라는 달콤함에 빠져봐요.",
                "오늘 할 일 중 하나를 골라 중간에 멈추지 않고 30분간 집중해보기",
                "타이머");
        saveFortune(belief2, "어제보다 더 즐거운 나, 더 성장한 나.",
                "어제보다 조금 더 나아진 점 하나 떠올려보기",
                "연한 노란색");
        saveFortune(belief2, "오늘 웃으며 흘린 땀방울이 내일의 단단한 나를 만들 거에요.",
                "힘들었던 일 하나를 ‘그럼에도 배운 점’으로 바꿔 적어 보기",
                "손수건");
        saveFortune(belief2, "서툰 시작을 즐기세요.",
                "아직 익숙지 않은 일에 첫 행동만 해 보기",
                "새 노트");


        // 3. 현장에서 시작해서 현장을 넘어선다
        Belief belief3 = new Belief(
                "현장에서 시작해서 현장을 넘어선다",
                "고객의 요구 이면에 존재하는 현장의 니즈까지 통찰한다."+"고객의 문제를 해결하기 위해 새로운 대안을 실험한다.",
                "/images/card_belief_3.png"
        );
        beliefRepository.save(belief3);

        saveFortune(belief3, "내가 새긴 발자국을 믿어야 하는 날이에요.",
                "오늘 회사에서 한 일 중 가장 의미 있었다고 느낀 것 하나 적어 보기",
                "운동화");
        saveFortune(belief3, "가장 낮은 곳에서 질문하고 가장 높은 곳에서 대답을 찾아봐요.",
                "업무 중 생긴 사소한 질문 하나 꼭! 물어보기",
                "포스트잇");
        saveFortune(belief3, "작은 물결이 모여 거대한 강을 만듭니다.",
                "반복적으로 처리하는 업무 중 하나를 “~~왜 이렇게 하고 있지?”라고 한 줄 메모 남겨보기",
                "물방울 모양 스티커");
        saveFortune(belief3, "오늘은 구두 굽이 닳는 만큼 행운의 크기가 비례해서 커지는 날입니다.",
                "직접 움직여야 하는 일 하나 자진해서 맡아보기",
                "편한 신발/낮은 굽 구두");
        saveFortune(belief3, "지금 택한 작은 변화가 더 넓은 세상의 시작이에요.",
                "오늘 느낀 작은 불편함이나 아이디어 중 하나를 동료에게 메신저로 공유해보기",
                "종이 비행기 이모티콘");


        // 4. 오늘 치열한 고민이 내일 최선의 결과가 된다
        Belief belief4 = new Belief(
                "오늘 치열한 고민이 내일 최선의 결과가 된다",
                "'항상 최선일까?' 질문한다."+"전문성을 바탕으로 담당 업무에서 완벽함을 추구한다.",
                "/images/card_belief_4.png"
        );
        beliefRepository.save(belief4);

        saveFortune(belief4, "거듭된 담금질이 가장 단단한 강철을 만듭니다.", "한 번 더 검토하면 무엇이 달라질까요?", "단단한 자");
        saveFortune(belief4, "스스로 만족할 때까지 도전해보세요.", "내 기준을 조금 더 높여보면 어떨까요?", "트로피");
        saveFortune(belief4, "정상에 닿는 길은 가장 가파른 법입니다.", "지금 힘든 건 올라가고 있기 때문입니다.", "등산화");
        saveFortune(belief4, "지름길보다 정석을 택해봐요.", "원칙을 지키는 것이 가장 빠른 길입니다.", "직각자");
        saveFortune(belief4, "가장 깊은 사색 끝에 가장 선명한 답이 있습니다.", "잠시 멈춰서 깊이 생각해볼 문제는?", "생각하는 의자");


        // 5. 나는 나의 동료가 나의 성장을 위한 동반자임을 믿는다
        Belief belief5 = new Belief(
                "나는 나의 동료가 나의 성장을 위한 동반자임을 믿는다",
                "동료를 신뢰(전문성)하며, 공동의 목표를 위해 함께 노력한다."+
                "자신의 지식과 경험을 열린 마음으로 공유한다.",
                "/images/card_belief_5.png"
        );
        beliefRepository.save(belief5);

        saveFortune(belief5, "동료와의 협동이 상상 이상의 시너지를 만들어 내는 날이에요.",
                "동료 한 명에게 간단한 도움 요청하기",
                "퍼즐 조각");
        saveFortune(belief5, "주변인에게 마음을 열고 귀를 기울여봐요.",
                "동료의 말을 끝까지 끊지 않고 들어보기",
                "줄 이어폰");
        saveFortune(belief5, "오늘 당신이 베푼 친절이 내일 가장 강력한 지원군이 될 거에요.",
                "동료에게 “~~해서 감사해요.” 한 마디 전하기",
                "아이스 아메리카노(Tall Size)");
        saveFortune(belief5, "서로의 부족함을 채워줄 때 비로소 성장하는 하루입니다.",
                "내가 잘 모르는 부분 하나를 동료에게 바로 물어보기",
                "화살표 아이콘");
        saveFortune(belief5, "오늘은 말을 아끼기보다 동료에게 지혜를 나눠주세요.",
                "내가 알고 있는 꿀팁 하나만 동료에게 공유해보기",
                "마이크");


        // 6. 나는 성숙한 마음으로 경청하고, 다름을 존중한다
        Belief belief6 = new Belief(
                "나는 성숙한 마음으로 경청하고, 다름을 존중한다",
                "상대를 존중하며 경청한다." + "의견을 예의 있게 표현하고, 전문성과 논리로 이유를 설명한다.",
                "/images/card_belief_6.png"
        );
        beliefRepository.save(belief6);

        saveFortune(belief6, "귀를 기울이는 만큼 행운이 올 거에요.",
                "관심 없는 분야에 경청 후 몰랐던 사실 하나 발견 해보기",
                "돋보기");
        saveFortune(belief6, "나와 다른 의견으로 시야가 넓어지는 하루입니다.",
                "나와 다른 의견에 “그럴 수도 있겠네요.” 말해보기",
                "넓은 창문");
        saveFortune(belief6, "비판의 칼날보다 공감의 방패가 더 강력한 하루입니다.",
                "비판 대신 “그렇게 생각하신 이유가 이해돼요.”라고 말해보기",
                "털실");
        saveFortune(belief6, "오늘은 먼저 듣고 나중에 말해 보아요.",
                " 내 의견 말하기 전에 상대방의 말을 한 줄로 요약해주기",
                "헤드셋");
        saveFortune(belief6, "부드러운 경청이 엉킨 오해를 풀어주는 하루입니다.",
                "상대 말이 끝난 후 고개 끄덕이며 공감하기",
                "부드러운 쿠션");


        // 7. 나는 내가 선택한 이 곳에서 가치 있는 일을 하고 있다
        Belief belief7 = new Belief(
                "나는 내가 선택한 이 곳에서 가치 있는 일을 하고 있다",
                "나는 내가 선택한 이 곳에서 가치 있는 일을 하고 있다.",
                "/images/card_belief_7.png"
        );
        beliefRepository.save(belief7);

        saveFortune(belief7, "지금 걷고 있는 이 길이 당신을 가장 빛나는 곳으로 인도할 거예요.",
                "오늘 한 일 중 자랑스러운 일 하나 적어보기",
                "햇빛이 들어오는 자리");
        saveFortune(belief7, "당신의 오늘이 역사가 됩니다.",
                "오늘 하루를 한 단어로 정리해보기",
                "구름");
        saveFortune(belief7, "당신의 선택을 믿고 나아가세요.",
                "결정한 일을 의심 말고 그대로 실행하기",
                "엘레베이터 ‘열림’ 버튼");
        saveFortune(belief7, "당신이 심은 정성이 내일의 커다란 숲이 됩니다.",
                "동료가 알아차리지 못하더라도 나만 아는 노력 하나 보태보기",
                "작은 화분");
        saveFortune(belief7, "오늘 자부심이라는 거울에 당신을 비춰보세요.",
                "스스로에게 “오늘 너무 잘했어.” 한 번 말해주기",
                "작은 손 거울");

        System.out.println("초기 데이터(7가지 믿음 & 35개 운세) 적재");
    }

    private void saveFortune(Belief belief, String message, String question, String luckyItem) {
        Fortune fortune = new Fortune();
        fortune.setBelief(belief);
        fortune.setMessage(message);
        fortune.setQuestion(question);
        fortune.setLuckyItem(luckyItem);
        fortune.setCharacterImageUrl("/images/beaver_default.png");

        fortuneRepository.save(fortune);
    }
}