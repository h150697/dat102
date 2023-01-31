package no.hvl.dat102.tabell;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import no.hvl.dat102.adt.KoeADTTest;
import no.hvl.dat102.adt.KoeADT;

class TabellSirkulaerKoeTest extends KoeADTTest{

	@Override
	protected KoeADT<Integer> reset() {
		return new TabellSirkulaerKoe<Integer>();
	}

}
