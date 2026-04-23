package org.apache.commons.math3.primes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.primes.Primes;
import org.junit.jupiter.api.Test;

public class PrimesGrok_OS5Test {

@Test
void testNextPrime_Negative() {
   assertThrows(MathIllegalArgumentException.class, () -> Primes.nextPrime(-1));
}

@Test
void testNextPrime_Zero() {
   assertEquals(2, Primes.nextPrime(0));
}

@Test
void testNextPrime_One() {
   assertEquals(2, Primes.nextPrime(1));
}

@Test
void testNextPrime_Two() {
   assertEquals(2, Primes.nextPrime(2));
}

@Test
void testNextPrime_Three() {
   assertEquals(3, Primes.nextPrime(3));
}

@Test
void testNextPrime_Four() {
   assertEquals(5, Primes.nextPrime(4));
}

@Test
void testNextPrime_Five() {
   assertEquals(5, Primes.nextPrime(5));
}

@Test
void testNextPrime_Six() {
   assertEquals(7, Primes.nextPrime(6));
}

@Test
void testNextPrime_Seven() {
   assertEquals(7, Primes.nextPrime(7));
}

@Test
void testNextPrime_Eight() {
   assertEquals(11, Primes.nextPrime(8));
}

@Test
void testNextPrime_Nine() {
   assertEquals(11, Primes.nextPrime(9));
}

@Test
void testNextPrime_Ten() {
   assertEquals(11, Primes.nextPrime(10));
}

@Test
void testNextPrime_Eleven() {
   assertEquals(11, Primes.nextPrime(11));
}

@Test
void testNextPrime_Twelve() {
   assertEquals(13, Primes.nextPrime(12));
}

@Test
void testNextPrime_Fifteen() {
   assertEquals(17, Primes.nextPrime(15));
}

@Test
void testNextPrime_Eighteen() {
   assertEquals(19, Primes.nextPrime(18));
}

@Test
void testNextPrime_Twenty() {
   assertEquals(23, Primes.nextPrime(20));
}

@Test
void testNextPrime_TwentyOne() {
   assertEquals(23, Primes.nextPrime(21));
}

@Test
void testNextPrime_TwentyTwo() {
   assertEquals(23, Primes.nextPrime(22));
}

@Test
void testNextPrime_TwentyThree() {
   assertEquals(23, Primes.nextPrime(23));
}

@Test
void testNextPrime_TwentyFour() {
   assertEquals(29, Primes.nextPrime(24));
}

@Test
void testNextPrime_TwentyFive() {
   assertEquals(29, Primes.nextPrime(25));
}

@Test
void testNextPrime_TwentySix() {
   assertEquals(29, Primes.nextPrime(26));
}

@Test
void testNextPrime_TwentySeven() {
   assertEquals(29, Primes.nextPrime(27));
}

@Test
void testNextPrime_TwentyEight() {
   assertEquals(29, Primes.nextPrime(28));
}

@Test
void testNextPrime_TwentyNine() {
   assertEquals(29, Primes.nextPrime(29));
}

@Test
void testNextPrime_Thirty() {
   assertEquals(31, Primes.nextPrime(30));
}

@Test
void testNextPrime_ThirtyOne() {
   assertEquals(31, Primes.nextPrime(31));
}

@Test
void testNextPrime_ThirtyTwo() {
   assertEquals(37, Primes.nextPrime(32));
}

@Test
void testNextPrime_ThirtyThree() {
   assertEquals(37, Primes.nextPrime(33));
}

@Test
void testNextPrime_ThirtyFour() {
   assertEquals(37, Primes.nextPrime(34));
}

@Test
void testNextPrime_ThirtyFive() {
   assertEquals(37, Primes.nextPrime(35));
}

@Test
void testNextPrime_ThirtySix() {
   assertEquals(37, Primes.nextPrime(36));
}

@Test
void testNextPrime_ThirtySeven() {
   assertEquals(37, Primes.nextPrime(37));
}

@Test
void testNextPrime_ThirtyEight() {
   assertEquals(41, Primes.nextPrime(38));
}

@Test
void testNextPrime_ThirtyNine() {
   assertEquals(41, Primes.nextPrime(39));
}

@Test
void testNextPrime_Forty() {
   assertEquals(41, Primes.nextPrime(40));
}

@Test
void testNextPrime_FortyOne() {
   assertEquals(41, Primes.nextPrime(41));
}

@Test
void testNextPrime_FortyTwo() {
   assertEquals(43, Primes.nextPrime(42));
}

@Test
void testNextPrime_FortyThree() {
   assertEquals(43, Primes.nextPrime(43));
}

@Test
void testNextPrime_FortyFour() {
   assertEquals(47, Primes.nextPrime(44));
}

@Test
void testNextPrime_FortyFive() {
   assertEquals(47, Primes.nextPrime(45));
}

@Test
void testNextPrime_FortySix() {
   assertEquals(47, Primes.nextPrime(46));
}

@Test
void testNextPrime_FortySeven() {
   assertEquals(47, Primes.nextPrime(47));
}

@Test
void testNextPrime_FortyEight() {
   assertEquals(53, Primes.nextPrime(48));
}

@Test
void testNextPrime_FortyNine() {
   assertEquals(53, Primes.nextPrime(49));
}

@Test
void testNextPrime_Fifty() {
   assertEquals(53, Primes.nextPrime(50));
}

@Test
void testNextPrime_FiftyOne() {
   assertEquals(53, Primes.nextPrime(51));
}

@Test
void testNextPrime_FiftyTwo() {
   assertEquals(53, Primes.nextPrime(52));
}

@Test
void testNextPrime_FiftyThree() {
   assertEquals(53, Primes.nextPrime(53));
}

@Test
void testNextPrime_FiftyFour() {
   assertEquals(59, Primes.nextPrime(54));
}

@Test
void testNextPrime_FiftyFive() {
   assertEquals(59, Primes.nextPrime(55));
}

@Test
void testNextPrime_FiftySix() {
   assertEquals(59, Primes.nextPrime(56));
}

@Test
void testNextPrime_FiftySeven() {
   assertEquals(59, Primes.nextPrime(57));
}

@Test
void testNextPrime_FiftyEight() {
   assertEquals(59, Primes.nextPrime(58));
}

@Test
void testNextPrime_FiftyNine() {
   assertEquals(59, Primes.nextPrime(59));
}

@Test
void testNextPrime_Sixty() {
   assertEquals(61, Primes.nextPrime(60));
}

@Test
void testNextPrime_SixtyOne() {
   assertEquals(61, Primes.nextPrime(61));
}

@Test
void testNextPrime_SixtyTwo() {
   assertEquals(67, Primes.nextPrime(62));
}

@Test
void testNextPrime_SixtyThree() {
   assertEquals(67, Primes.nextPrime(63));
}

@Test
void testNextPrime_SixtyFour() {
   assertEquals(67, Primes.nextPrime(64));
}

@Test
void testNextPrime_SixtyFive() {
   assertEquals(67, Primes.nextPrime(65));
}

@Test
void testNextPrime_SixtySix() {
   assertEquals(67, Primes.nextPrime(66));
}

@Test
void testNextPrime_SixtySeven() {
   assertEquals(67, Primes.nextPrime(67));
}

@Test
void testNextPrime_SixtyEight() {
   assertEquals(71, Primes.nextPrime(68));
}

@Test
void testNextPrime_SixtyNine() {
   assertEquals(71, Primes.nextPrime(69));
}

@Test
void testNextPrime_Seventy() {
   assertEquals(71, Primes.nextPrime(70));
}

@Test
void testNextPrime_SeventyOne() {
   assertEquals(71, Primes.nextPrime(71));
}

@Test
void testNextPrime_SeventyTwo() {
   assertEquals(73, Primes.nextPrime(72));
}

@Test
void testNextPrime_SeventyThree() {
   assertEquals(73, Primes.nextPrime(73));
}

@Test
void testNextPrime_SeventyFour() {
   assertEquals(79, Primes.nextPrime(74));
}

@Test
void testNextPrime_SeventyFive() {
   assertEquals(79, Primes.nextPrime(75));
}

@Test
void testNextPrime_SeventySix() {
   assertEquals(79, Primes.nextPrime(76));
}

@Test
void testNextPrime_SeventySeven() {
   assertEquals(79, Primes.nextPrime(77));
}

@Test
void testNextPrime_SeventyEight() {
   assertEquals(79, Primes.nextPrime(78));
}

@Test
void testNextPrime_SeventyNine() {
   assertEquals(79, Primes.nextPrime(79));
}

@Test
void testNextPrime_Eighty() {
   assertEquals(83, Primes.nextPrime(80));
}

@Test
void testNextPrime_EightyOne() {
   assertEquals(83, Primes.nextPrime(81));
}

@Test
void testNextPrime_EightyTwo() {
   assertEquals(83, Primes.nextPrime(82));
}

@Test
void testNextPrime_EightyThree() {
   assertEquals(83, Primes.nextPrime(83));
}

@Test
void testNextPrime_EightyFour() {
   assertEquals(89, Primes.nextPrime(84));
}

@Test
void testNextPrime_EightyFive() {
   assertEquals(89, Primes.nextPrime(85));
}

@Test
void testNextPrime_EightySix() {
   assertEquals(89, Primes.nextPrime(86));
}

@Test
void testNextPrime_EightySeven() {
   assertEquals(89, Primes.nextPrime(87));
}

@Test
void testNextPrime_EightyEight() {
   assertEquals(89, Primes.nextPrime(88));
}

@Test
void testNextPrime_EightyNine() {
   assertEquals(89, Primes.nextPrime(89));
}

@Test
void testNextPrime_Ninety() {
   assertEquals(97, Primes.nextPrime(90));
}

@Test
void testNextPrime_NinetyOne() {
   assertEquals(97, Primes.nextPrime(91));
}

@Test
void testNextPrime_NinetyTwo() {
   assertEquals(97, Primes.nextPrime(92));
}

@Test
void testNextPrime_NinetyThree() {
   assertEquals(97, Primes.nextPrime(93));
}

@Test
void testNextPrime_NinetyFour() {
   assertEquals(97, Primes.nextPrime(94));
}

@Test
void testNextPrime_NinetyFive() {
   assertEquals(97, Primes.nextPrime(95));
}

@Test
void testNextPrime_NinetySix() {
   assertEquals(97, Primes.nextPrime(96));
}

@Test
void testNextPrime_NinetySeven() {
   assertEquals(97, Primes.nextPrime(97));
}

@Test
void testNextPrime_NinetyEight() {
   assertEquals(101, Primes.nextPrime(98));
}

@Test
void testNextPrime_NinetyNine() {
   assertEquals(101, Primes.nextPrime(99));
}

@Test
void testNextPrime_OneHundred() {
   assertEquals(101, Primes.nextPrime(100));
}

@Test
void testNextPrime_OneHundredOne() {
   assertEquals(101, Primes.nextPrime(101));
}

@Test
void testNextPrime_OneHundredTwo() {
   assertEquals(103, Primes.nextPrime(102));
}

@Test
void testNextPrime_OneHundredThree() {
   assertEquals(103, Primes.nextPrime(103));
}

@Test
void testNextPrime_OneHundredFour() {
   assertEquals(107, Primes.nextPrime(104));
}

@Test
void testNextPrime_OneHundredFive() {
   assertEquals(107, Primes.nextPrime(105));
}

@Test
void testNextPrime_OneHundredSix() {
   assertEquals(107, Primes.nextPrime(106));
}

@Test
void testNextPrime_OneHundredSeven() {
   assertEquals(107, Primes.nextPrime(107));
}

@Test
void testNextPrime_OneHundredEight() {
   assertEquals(109, Primes.nextPrime(108));
}

@Test
void testNextPrime_OneHundredNine() {
   assertEquals(109, Primes.nextPrime(109));
}

@Test
void testNextPrime_OneHundredTen() {
   assertEquals(113, Primes.nextPrime(110));
}

@Test
void testNextPrime_OneHundredEleven() {
   assertEquals(113, Primes.nextPrime(111));
}

@Test
void testNextPrime_OneHundredTwelve() {
   assertEquals(113, Primes.nextPrime(112));
}

@Test
void testNextPrime_OneHundredThirteen() {
   assertEquals(113, Primes.nextPrime(113));
}

@Test
void testNextPrime_OneHundredFourteen() {
   assertEquals(127, Primes.nextPrime(114));
}

@Test
void testNextPrime_OneHundredFifteen() {
   assertEquals(127, Primes.nextPrime(115));
}

@Test
void testNextPrime_OneHundredSixteen() {
   assertEquals(127, Primes.nextPrime(116));
}

@Test
void testNextPrime_OneHundredSeventeen() {
   assertEquals(127, Primes.nextPrime(117));
}

@Test
void testNextPrime_OneHundredEighteen() {
   assertEquals(127, Primes.nextPrime(118));
}

@Test
void testNextPrime_OneHundredNineteen() {
   assertEquals(127, Primes.nextPrime(119));
}

@Test
void testNextPrime_OneHundredTwenty() {
   assertEquals(127, Primes.nextPrime(120));
}

@Test
void testNextPrime_OneHundredTwentyOne() {
   assertEquals(127, Primes.nextPrime(121));
}

@Test
void testNextPrime_OneHundredTwentyTwo() {
   assertEquals(127, Primes.nextPrime(122));
}

@Test
void testNextPrime_OneHundredTwentyThree() {
   assertEquals(127, Primes.nextPrime(123));
}

@Test
void testNextPrime_OneHundredTwentyFour() {
   assertEquals(127, Primes.nextPrime(124));
}

@Test
void testNextPrime_OneHundredTwentyFive() {
   assertEquals(127, Primes.nextPrime(125));
}

@Test
void testNextPrime_OneHundredTwentySix() {
   assertEquals(127, Primes.nextPrime(126));
}

@Test
void testNextPrime_OneHundredTwentySeven() {
   assertEquals(127, Primes.nextPrime(127));
}

@Test
void testNextPrime_OneHundredTwentyEight() {
   assertEquals(131, Primes.nextPrime(128));
}

@Test
void testNextPrime_OneHundredTwentyNine() {
   assertEquals(131, Primes.nextPrime(129));
}

@Test
void testNextPrime_OneHundredThirty() {
   assertEquals(131, Primes.nextPrime(130));
}

@Test
void testNextPrime_OneHundredThirtyOne() {
   assertEquals(131, Primes.nextPrime(131));
}

@Test
void testNextPrime_OneHundredThirtyTwo() {
   assertEquals(137, Primes.nextPrime(132));
}

@Test
void testNextPrime_OneHundredThirtyThree() {
   assertEquals(137, Primes.nextPrime(133));
}

@Test
void testNextPrime_OneHundredThirtyFour() {
   assertEquals(137, Primes.nextPrime(134));
}

@Test
void testNextPrime_OneHundredThirtyFive() {
   assertEquals(137, Primes.nextPrime(135));
}

@Test
void testNextPrime_OneHundredThirtySix() {
   assertEquals(137, Primes.nextPrime(136));
}

@Test
void testNextPrime_OneHundredThirtySeven() {
   assertEquals(137, Primes.nextPrime(137));
}

@Test
void testNextPrime_OneHundredThirtyEight() {
   assertEquals(139, Primes.nextPrime(138));
}

@Test
void testNextPrime_OneHundredThirtyNine() {
   assertEquals(139, Primes.nextPrime(139));
}

@Test
void testNextPrime_OneHundredForty() {
   assertEquals(149, Primes.nextPrime(140));
}

@Test
void testNextPrime_OneHundredFortyOne() {
   assertEquals(149, Primes.nextPrime(141));
}

@Test
void testNextPrime_OneHundredFortyTwo() {
   assertEquals(149, Primes.nextPrime(142));
}

@Test
void testNextPrime_OneHundredFortyThree() {
   assertEquals(149, Primes.nextPrime(143));
}

@Test
void testNextPrime_OneHundredFortyFour() {
   assertEquals(149, Primes.nextPrime(144));
}

@Test
void testNextPrime_OneHundredFortyFive() {
   assertEquals(149, Primes.nextPrime(145));
}

@Test
void testNextPrime_OneHundredFortySix() {
   assertEquals(149, Primes.nextPrime(146));
}

@Test
void testNextPrime_OneHundredFortySeven() {
   assertEquals(149, Primes.nextPrime(147));
}

@Test
void testNextPrime_OneHundredFortyEight() {
   assertEquals(149, Primes.nextPrime(148));
}

@Test
void testNextPrime_OneHundredFortyNine() {
   assertEquals(149, Primes.nextPrime(149));
}

@Test
void testNextPrime_OneHundredFifty() {
   assertEquals(151, Primes.nextPrime(150));
}

@Test
void testNextPrime_OneHundredFiftyOne() {
   assertEquals(151, Primes.nextPrime(151));
}

@Test
void testNextPrime_OneHundredFiftyTwo() {
   assertEquals(157, Primes.nextPrime(152));
}

@Test
void testNextPrime_OneHundredFiftyThree() {
   assertEquals(157, Primes.nextPrime(153));
}

@Test
void testNextPrime_OneHundredFiftyFour() {
   assertEquals(157, Primes.nextPrime(154));
}

@Test
void testNextPrime_OneHundredFiftyFive() {
   assertEquals(157, Primes.nextPrime(155));
}

@Test
void testNextPrime_OneHundredFiftySix() {
   assertEquals(157, Primes.nextPrime(156));
}

@Test
void testNextPrime_OneHundredFiftySeven() {
   assertEquals(157, Primes.nextPrime(157));
}

@Test
void testNextPrime_OneHundredFiftyEight() {
   assertEquals(163, Primes.nextPrime(158));
}

@Test
void testNextPrime_OneHundredFiftyNine() {
   assertEquals(163, Primes.nextPrime(159));
}

@Test
void testNextPrime_OneHundredSixty() {
   assertEquals(163, Primes.nextPrime(160));
}

@Test
void testNextPrime_OneHundredSixtyOne() {
   assertEquals(163, Primes.nextPrime(161));
}

@Test
void testNextPrime_OneHundredSixtyTwo() {
   assertEquals(163, Primes.nextPrime(162));
}

@Test
void testNextPrime_OneHundredSixtyThree() {
   assertEquals(163, Primes.nextPrime(163));
}

@Test
void testNextPrime_OneHundredSixtyFour() {
   assertEquals(167, Primes.nextPrime(164));
}

@Test
void testNextPrime_OneHundredSixtyFive() {
   assertEquals(167, Primes.nextPrime(165));
}

@Test
void testNextPrime_OneHundredSixtySix() {
   assertEquals(167, Primes.nextPrime(166));
}

@Test
void testNextPrime_OneHundredSixtySeven() {
   assertEquals(167, Primes.nextPrime(167));
}

@Test
void testNextPrime_OneHundredSixtyEight() {
   assertEquals(173, Primes.nextPrime(168));
}

@Test
void testNextPrime_OneHundredSixtyNine() {
   assertEquals(173, Primes.nextPrime(169));
}

@Test
void testNextPrime_OneHundredSeventy() {
   assertEquals(173, Primes.nextPrime(170));
}

@Test
void testNextPrime_OneHundredSeventyOne() {
   assertEquals(173, Primes.nextPrime(171));
}

@Test
void testNextPrime_OneHundredSeventyTwo() {
   assertEquals(173, Primes.nextPrime(172));
}

@Test
void testNextPrime_OneHundredSeventyThree() {
   assertEquals(173, Primes.nextPrime(173));
}

@Test
void testNextPrime_OneHundredSeventyFour() {
   assertEquals(179, Primes.nextPrime(174));
}

@Test
void testNextPrime_OneHundredSeventyFive() {
   assertEquals(179, Primes.nextPrime(175));
}

@Test
void testNextPrime_OneHundredSeventySix() {
   assertEquals(179, Primes.nextPrime(176));
}

@Test
void testNextPrime_OneHundredSeventySeven() {
   assertEquals(179, Primes.nextPrime(177));
}

@Test
void testNextPrime_OneHundredSeventyEight() {
   assertEquals(179, Primes.nextPrime(178));
}

@Test
void testNextPrime_OneHundredSeventyNine() {
   assertEquals(179, Primes.nextPrime(179));
}

@Test
void testNextPrime_OneHundredEighty() {
   assertEquals(181, Primes.nextPrime(180));
}

@Test
void testNextPrime_OneHundredEightyOne() {
   assertEquals(181, Primes.nextPrime(181));
}

@Test
void testNextPrime_OneHundredEightyTwo() {
   assertEquals(191, Primes.nextPrime(182));
}

@Test
void testNextPrime_OneHundredEightyThree() {
   assertEquals(191, Primes.nextPrime(183));
}

@Test
void testNextPrime_OneHundredEightyFour() {
   assertEquals(191, Primes.nextPrime(184));
}

@Test
void testNextPrime_OneHundredEightyFive() {
   assertEquals(191, Primes.nextPrime(185));
}

@Test
void testNextPrime_OneHundredEightySix() {
   assertEquals(191, Primes.nextPrime(186));
}

@Test
void testNextPrime_OneHundredEightySeven() {
   assertEquals(191, Primes.nextPrime(187));
}

@Test
void testNextPrime_OneHundredEightyEight() {
   assertEquals(191, Primes.nextPrime(188));
}

@Test
void testNextPrime_OneHundredEightyNine() {
   assertEquals(191, Primes.nextPrime(189));
}

@Test
void testNextPrime_OneHundredNinety() {
   assertEquals(191, Primes.nextPrime(190));
}

@Test
void testNextPrime_OneHundredNinetyOne() {
   assertEquals(191, Primes.nextPrime(191));
}

@Test
void testNextPrime_OneHundredNinetyTwo() {
   assertEquals(193, Primes.nextPrime(192));
}

@Test
void testNextPrime_OneHundredNinetyThree() {
   assertEquals(193, Primes.nextPrime(193));
}

@Test
void testNextPrime_OneHundredNinetyFour() {
   assertEquals(197, Primes.nextPrime(194));
}

@Test
void testNextPrime_OneHundredNinetyFive() {
   assertEquals(197, Primes.nextPrime(195));
}

@Test
void testNextPrime_OneHundredNinetySix() {
   assertEquals(197, Primes.nextPrime(196));
}

@Test
void testNextPrime_OneHundredNinetySeven() {
   assertEquals(197, Primes.nextPrime(197));
}

@Test
void testNextPrime_OneHundredNinetyEight() {
   assertEquals(199, Primes.nextPrime(198));
}

@Test
void testNextPrime_OneHundredNinetyNine() {
   assertEquals(199, Primes.nextPrime(199));
}

@Test
void testNextPrime_TwoHundred() {
   assertEquals(211, Primes.nextPrime(200));
}

}
