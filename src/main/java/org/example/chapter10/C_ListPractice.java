package org.example.chapter10;

/*  === 이벤트 관리 시스템 === //
    : 이번트 참가자 명단 & 대기열 관리를 위한 시스템
    - 참가자는 사전 등록된 명단을 통해 이벤트 참가
    -명단이 가득 찰 경우 대기열 추가, 참가자가 떠나면 대기열의 다음 사람이 추가

    1) 이벤트 참가자 명단 관리: 사전 등록, 당일 추가 참가자 등록 X
    : ArrayList (목록 추가/삭제 X / 참가자 조회 O)

    2) 대기열 관리
    : 이벤트의 한정된 좌석, 좌석이 모두 차면 추가 참가자는 대기열에 등록
    : LinkedList (목록 추가/삭제 O, 참가자 조회 X)
 */

import java.util.ArrayList;
import java.util.LinkedList;

class EventManagement {
    // == 필드 == //
    ArrayList<String> participantList = new ArrayList<>();
    LinkedList<String> waitingQueue = new LinkedList<>();

    // == 메서드 == //
    void addParticipant(String name) {
        participantList.add(name);
    }

    void addToWaitingQueue(String name) {
        waitingQueue.add(name);
    }

    void leaveParticipant(String name) {
        // 대기열의 인원이 존재해야만! 대기열 인원을 참가자 명단에 추가 가능
        // : 대기열 크기(.size())가 0이상
        if (waitingQueue.size() > 0) {
            String newParticipant = waitingQueue.remove(0); // 대기열에서 제거
            addParticipant(newParticipant); // 참가자 명단에 추가
        }
    }

    boolean checkParticipant(String name) {
        return participantList.contains(name);
    }

}

public class C_ListPractice {
    public static void main(String[] args) {
        EventManagement eventManagement = new EventManagement();

        eventManagement.addParticipant("빨간체리");
        eventManagement.addParticipant("샛노랑");
        eventManagement.addParticipant("초록메론");
        eventManagement.addParticipant("파란파파야");
        eventManagement.addParticipant("보라버섯");

        eventManagement.addToWaitingQueue("핑크용과");
        eventManagement.addToWaitingQueue("베이지베지밀");
        eventManagement.addToWaitingQueue("검정먹물");
        eventManagement.addToWaitingQueue("하늘솜사탕");

        System.out.println(eventManagement.participantList); // [빨간체리, 샛노랑, 초록메론, 파란파파야, 보라버섯]
        System.out.println(eventManagement.waitingQueue); // [핑크용과, 베이지베지밀, 검정먹물, 하늘솜사탕]

        eventManagement.addToWaitingQueue("샛노랑");
        eventManagement.addToWaitingQueue("싫은주황");

        System.out.println(eventManagement.waitingQueue); // [핑크용과, 베이지베지밀, 검정먹물, 하늘솜사탕, 샛노랑, 싫은주황]

        eventManagement.leaveParticipant("빨간체리");
        eventManagement.leaveParticipant("샛노랑");
        eventManagement.leaveParticipant("파란파파야");

        System.out.println(eventManagement.participantList); // [빨간체리, 샛노랑, 초록메론, 파란파파야, 보라버섯, 핑크용과, 베이지베지밀, 검정먹물]
        System.out.println(eventManagement.waitingQueue); // [하늘솜사탕, 샛노랑, 싫은주황]

        System.out.println(eventManagement.checkParticipant("샛노랑")); // true
        System.out.println(eventManagement.checkParticipant("하늘솜사탕")); // false

    }
}
