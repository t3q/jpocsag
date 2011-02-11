/*
	jPOCSAG, a POCSAG paging decoder written in Java.
    Copyright (C) 2009-2011 Christophe Jacquet, F8FTK.

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
*/


package jpocsag.pocsag;

public class AddressCodeword extends Codeword {
	private final int function;
	private final int address;
	
	public AddressCodeword(BCHDecoder.Correction corr) {
		super(corr);
		function = (int) ((word>>11) & 3);
		address = (int) ((word>>13) & 0x3FFFF);
	}
	
	public String toString() {
		return "[" + contents() + ": address " + address + "/" + function + "]";	
	}
	
	public int getFunction() {
		return function;
	}
	
	public int getAddress() {
		return address;
	}

	@Override
	public String getType() {
		return "addr";
	}
}
