#!/usr/bin/env ruby

require 'test/unit'
require_relative './roman-numerals.rb'

Class.new(Test::Unit::TestCase) do
  TESTCASES = {
    1    => "I"      ,
    3    => "III"    ,
    4    => "IV"     ,
    5    => "V"      ,
    6    => "VI"     ,
    10   => "X"      ,
    42   => "XLII"   ,
    58   => "LVIII"  ,
    101  => "CI"     ,
    2022 => "MMXXII" ,
  }

  TESTCASES.keys.sort.each do |an|
    define_method :"test_#{an}" do
      assert_equal RomanNumerals::from_arabic(an), TESTCASES[an]
    end
  end
end
