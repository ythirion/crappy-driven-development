#!/usr/bin/env ruby

module RomanNumerals
  RMAP = {
        1000 => "M"  ,
        900  => "CM" ,
        500  => "D"  ,
        400  => "CD" ,
        100  => "C"  ,
        90   => "XC" ,
        50   => "L"  ,
        40   => "XL" ,
        10   => "X"  ,
        9    => "IX" ,
        5    => "V"  ,
        4    => "IV" ,
        1    => "I"  ,
  }

  def self.from_arabic(an)
    raise ArgumentError.new("must be and integer greater than zero") if an <= 0
    k = RMAP.keys.sort.select { |i| i <= an }.last
    if k == an
      return RMAP[k]
    else
      return RMAP[k] + self.from_arabic(an - k)
    end
  end
end

if __FILE__ == $0
  if ARGV.size != 1 or ARGV[0].to_i == 0
    $stderr.puts "#{File.basename($0)} <arabic_number>"
    exit 1
  end
  $stderr.puts RomanNumerals::from_arabic(ARGV[0].to_i)
end
