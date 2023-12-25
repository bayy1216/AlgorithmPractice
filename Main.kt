import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*
import kotlin.collections.ArrayDeque
import kotlin.collections.HashSet
import kotlin.collections.LinkedHashSet

fun 입출력(){
    val br = BufferedReader(InputStreamReader(System.`in`)) // BufferedReader 생성
    val hello = br.readLine() // BufferedReader로 사용자 입력 받기

    // BufferedWriter
    val bw = BufferedWriter(OutputStreamWriter(System.`out`)) // BufferedWriter 생성
    bw.write("hello") // 일반 출력 
    bw.write(hello + "\n") // 출력 + 줄바꿈 
    bw.flush() // 남아있는 출력 비우기 
    bw.close() // 스트림 종료 
}

fun 문자열(){
    val jainoString = "안녕하세요 정자이노입니다."

    jainoString.length // 문자열의 길이 반환 > 14
    jainoString.indices // 구성된 문자의 범위 반환 > 0 .. 13

    jainoString.substring(startIndex = 1, endIndex =  3) // startIndex 와 endIndex 사이의 String 반환
    jainoString.slice(1 .. 3) // 입력한 범위의 String 반환

    jainoString.find{ char -> char == '안' } // 조건 식에 맞는 첫번째 문자 반환
    jainoString.filter{ char -> char == '안' } // 조건 식에 맞는 모든 문자를 합친 문자열 반환

    jainoString.take(3) // 앞의 문자 3개를 가진 문자열 생성 > 안녕하
    jainoString.drop(3) // 앞의 문자 3개를 버린 문자열 생성 > 세요 정자이노입니다.

    jainoString.replace(oldChar = '정', newChar = '김') // 문자 대치
    jainoString.replace("a[bc]+d?".toRegex(), "") // 정규식 적용
}

fun 배열(){
    // 원시타입은 Array 앞에 자료형을 붙여 사용할 수 있다. ex) BooleanArray, StringArray, ByteArray
    val intArray = IntArray(size = 3) // > [0, 0, 0]
    val intArrayOf = intArrayOf(0, 1, 2) // > [0, 1, 2] 지정한 값 대입
    val intArrayAscending = IntArray(size = 3){ init -> init } // > [0, 1, 2]
    val intArrayTwice = IntArray(size = 3){ init -> init * 2} // > [0, 2, 4]
}

fun 확장함수(){
    val intArray = IntArray(size = 10)

    intArray.sort() // 오름차순 정렬 함수
    intArray.sortDescending() // 내림차순 정렬 함수

    intArray.forEach{ value -> println("index $value") } // 배열의 모든 값 순환 함수
    intArray.forEachIndexed{ index, value -> println("index $index value $value") } // 배열의 모든 값, 인덱스 순환 함수

    intArray.filter{ index -> index == 0 } // 입력한 조건에 일치하는 값으로 구성된 리스트 반환 함수
    intArray.filterNot { index -> index == 0 } // 입력한 조건에 일치하지 않는 값으로 구성된 리스트 반환 함수

    intArray.sliceArray(IntRange(3, 9)) // 인덱스 범위에 따른 배열 반환 함수
    intArray.slice(1 .. 3) // 인덱스 범위에 따른 리스트 반환 함수

    intArray.sum() // 배열의 모든 값 합 반환 함수
    intArray.sumOf{ index -> index * 2} // 조건을 적용한 모든 값 합 반환 함수

    intArray.maxOrNull() // 최댓값, 크기가 없는 경우 null 반환 함수
    intArray.minOrNull() // 최솟값, 크기가 없는 경우 null 반환 함수

    println(intArray.contentToString()) // 배열의 모든 값 출력 함수
}

fun 다차원_배열(){
    val charArrayInArray = arrayOf(
        charArrayOf('자', '이', '노'),
        charArrayOf('도', '미', '닉'),
    ) // > [['자', '이', '노'], ['도', '미', '닉']]

    val intArrayInArray = Array(size = 3){ IntArray(size = 4){ init -> 2 } }
    // > [[2, 2, 2, 2], [2, 2, 2, 2], [2, 2, 2, 2]]
}

fun arrayDeque(){
    val arrayDeque = ArrayDeque<Int>() // ArrayDeque 선언
    // val arrayDequeWithInitialList = ArrayDeque(listOf(1, 2, 3)) // 초기 값 대입 가능

    arrayDeque.add(1) // 뒤에 1 추가
    arrayDeque.addAll(listOf(2, 3, 4)) // 뒤에 리스트의 값 전부 추가

    arrayDeque.addFirst(0) // 앞에 0 추가
    arrayDeque.addLast(5) //  뒤에 5 추가. add() 와 같다.
    // [0, 1, 2, 3, 4, 5]

    arrayDeque.removeFirstOrNull() // 맨 앞 제거
    arrayDeque.removeLastOrNull() // 맨 뒤 제거
    // [1, 2, 3, 4]
}

fun list(){
    val immutableList: List<Int> = List(size = 3){ init -> init } // 불변 리스트 생성
    println(immutableList) // > [1, 2, 3]
    val immutableListOf: List<Int> = listOf(1, 2, 3) // listOf() 메소드를 통해 리스트 생성
    println(immutableListOf) // > [1, 2, 3]

    val mutableList: MutableList<Int> = MutableList(size = 3){ init -> init } // 가변 리스트 생성
    println(mutableList) // > [1, 2, 3]
    val mutableListOf: MutableList<Int> = mutableListOf(1, 2, 3)
    println(mutableListOf) // > [1, 2, 3]

    val iList = listOf("spotlight", "파노라마", "정자이노", "헬로") // 불변 리스트 Immutable
    println(iList.size) // 리스트 사이즈
    println(iList.indexOf("정자이노")) // 정자이노 index
    println(iList.get(2)) // 정자이노 3번째 값

    val mList = mutableListOf("hello", "Qwe", "bang", "아발론") // 가변 리스트 Mutable
    mList.add("찰리푸스") // '찰리푸스' 값 추가
    mList.remove("아발론") // '아발론' 값 제거
    mList.removeAt(0) // 1번 인덱스 제거
    mList.addAll(iList) // 'iList' 리스트 추가
}

fun set(){
    val iSet = setOf(3, 2, 1, 4, 5, 2, 1, 3) // Immutable Set
    println(iSet) // [3, 2, 1, 4, 5]
    println(iSet.contains(1)) // true

    val mSet = mutableSetOf(3, 1, 5, 4, 2, 1) // Mutable Set
    mSet.add(0) // 0 더하기
    mSet.remove(3) // 3 제거
    mSet.removeIf{ it < 3 } // 3 보다 작은 수 모두 제거
    println(mSet) // [5, 4]

    val hashSet : HashSet<Int> = hashSetOf(3, 5, 8, 1)
    val sortedSet : TreeSet<Int> = sortedSetOf(1, 9, 3, 2)
    val linkedSet : LinkedHashSet<Int> = linkedSetOf(13, 12, 4, 6)

    println(hashSet) // [8, 1, 3, 5]
    println(sortedSet) // [1, 2, 3, 9]
    println(linkedSet) // [13, 12, 4, 6]
}

fun map(){
    val jainoMap : MutableMap<String, String> = mutableMapOf("jinho" to "jaino", "simon" to "jiho")
    println(jainoMap.values) // [jaino, jiho]
    println(jainoMap.keys) // [jinho, simon]

    jainoMap.put("age", "23") // put(key, value)
    jainoMap.remove("simon")
    println(jainoMap) // {jinho=jaino, age=23}

    val hashMap = HashMap<Int, String>()
    repeat(3){
        hashMap.put(key = it, value = (it + 1).toString()) // 해시 맵 초기화 {1 to "1"}, ...
    }

    println(hashMap.keys) // > [0, 1, 2]
    println(hashMap.values) // > [1, 2, 3]

    println(hashMap.containsKey(2)) // true
    println(hashMap.containsValue("0")) // false

    println(hashMap.toSortedMap()) // > {0=1, 1=2, 2=3}

    // 필자가 많이 사용하는 방법
    val goal = "2"
    hashMap.keys.forEach{
        if(hashMap.get(it) == goal){ // value에 접근하여 다른 조건식 적용
            return
        }
    }
}

fun 정렬(){
    val list = mutableListOf(1, 2, 3, 4, 5)

    list.sort() // 오름차순 정렬 > [1, 2, 3, 4, 5]
    list.sortDescending() // 내림차순 정렬 > [5, 4, 3, 2, 1]
    list.reverse() // 리스트 뒤집기 > [1, 2, 3, 4, 5]

    list.sortBy{ int -> int % 3 } // > 정렬 기준을 입력하여, 정렬한다.
    println(list) // > [3, 1, 4, 2, 5] > 3으로 나눈 나머지의 오름차순

    list.sortWith(compareBy { int -> int % 2 }) // > Comparator 에 정의한 정렬 기준으로 정렬한다.
    println(list) // > 4, 2, 3, 1, 5 > 2로 나눈 나머지의 오름차순

    list.sortWith(compareBy<Int> { init ->  init % 2 }.then(compareBy { int -> -int }))
    println(list) // > [4, 2, 5, 3, 1] > 2로 나눈 나머지의 오름차순, 나머지가 같다면 내림차순 정렬
}

fun 순회(){
    val list = listOf(1, 2, 3, 4, 5)

    list.forEach{ // 각 요소의 value에 접근
        println(it * 2)
    } // [2, 4, 6, 8, 10]

    list.forEachIndexed{ index, value -> // 각 요소의 index, value에 접근
        println("index[$index] = $value")
    } // index[0] = 1  index[1] = 2 index[2] = 3 index[3] = 4 index[4] = 5

    val onEachList = list.onEach { // 모든 요소의 value에 적용할 함수 전달
        print(it * 2)
    } // > 246810
}

fun 매핑(){
    val list = listOf(1, 2, 3, 4, 5)
    val listWithNull = listOf(1, null, 2, null, 3)

    val twiceList = list.map{ it * 2 } // [2, 4, 6, 8, 10]
    val listWithNotNull = listWithNull.mapNotNull { it?.times(2) } // [2, 4, 6]
    val listWithJ = list.flatMap { listOf(it * 3, it * 4, it * 5) }
    print(listWithJ) // [3, 4, 5, 6, 8, 10, 9, 12, 15, 12, 16, 20, 15, 20, 25]

    val groupMap = list.groupBy { it % 2 == 0 } // {false=[1, 3, 5], true=[2, 4]}
}
fun 필터링(){
    val list = listOf(1, 2, 3, 4, 5)
    val listWithNull = listOf(1, null, 2, null, 3)

    val twiceList = list.filter{ it % 2 == 0} // [2, 4, 6]
    val notTwiceList = list.filterNot { it % 2 == 0 } // [1, 3, 5]
    val notNullList = listWithNull.filterNotNull() // [1, 2, 3]
}

fun 검사(){
    val list = listOf(1, 2, 3, 4, 5)

    if (list.any { it % 2 == 0 }) {
        println("적어도 하나의 짝수가 존재합니다.")
    }else{
        println("모든 수가 홀수입니다.")
    }

    if (list.all { it % 2 == 0 }) {
        println("모든 수가 짝수입니다.")
    }else{
        println("적어도 하나의 홀수가 존재합니다.")
    }

    if (list.none { it > 120 }) {
        println("모든 수가 120보다 작습니다.")
    }else{
        println("적어도 하나의 수가 120보다 큽니다.")
    }
}

fun 중첩(){
    val list = listOf(3, 1, 6, 2, 12)

    println(list.reduce{ total, num -> // 첫번 째 요소부터 시작한다.
        total + num
    }) // 24

    println(list.fold(12){ total, num -> // 지정한 초기값부터 시작한다.
        total + num
    }) // 초기값 12, 총 36
}
fun 집합(){
    val list = listOf(1, 2, 2, 3, 3)
    val list1 = listOf(1, 2, 3, 4, 5)
    val list2 = listOf(3, 4, 5, 6, 7)

    println(list.distinct()) // [1, 2, 3] 중복되는 값 제외 list
    println(list1.intersect(list2)) // [3, 4, 5] 두 컬렉션 간 중첩되는 값 list
    println(list1.union(list2)) // [1, 2, 3, 4, 5, 6, 7] 중첩되는 값 소거
    println(list1.plus(list2)) // [1, 2, 3, 4, 5, 3, 4, 5, 6, 7] 중첩되는 값 소거 하지 않음
}