package no.hvl.dat102.adt;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import no.hvl.dat102.exceptions.EmptyCollectionException;

public abstract class KoeADTTest {

	// Referanse til stabel
	private KoeADT<Integer> koe;

	// Testdata
	private Integer e0 = 1;
	private Integer e1 = 2;
	private Integer e2 = 3;
	private Integer e3 = 4;
	private Integer e4 = 5;

	protected abstract KoeADT<Integer> reset();

	/**
	 * Hent en ny stabel for hver test.
	 * 
	 * @return
	 */
	@BeforeEach
	public void setup() {
		koe = reset();
	}

	/**
	 * Sjekker at en ny kø er tom
	 */
	@Test
	public void nyKoeErTom() {
		assertTrue(koe.erTom());
	}

	/**
	 * Sjekker at forventet resultat etter innKoe() metode gir forventet resultat:
	 * false
	 */
	@Test
	public void ikkeTomKoe() {
		koe.innKoe(e0);
		koe.innKoe(e1);
		assertFalse(koe.erTom());
	}

	/**
	 * Tester inn og ut av kø
	 */
	@Test
	public void innUtKø() {
		koe.innKoe(e2);
		koe.innKoe(e2);
		koe.innKoe(e3);
		koe.innKoe(e3);
		koe.innKoe(e4);

		assertEquals(e2, koe.utKoe());
		assertEquals(e2, koe.utKoe());
		assertEquals(e3, koe.utKoe());
		assertEquals(e3, koe.utKoe());
		assertEquals(e4, koe.utKoe());

	}

	/**
	 * Sjekker om køen er tom etter inn og ut metode.
	 */
	@Test
	public void innUtErTom() {

		koe.innKoe(e0);
		koe.utKoe();
		assertTrue(koe.erTom());

	}
	
	/**
	 * Tester foerste
	 */
	@Test
	public void InnUtInnUtInnInnUtForste() {
		koe.innKoe(e0);
		koe.utKoe();
		koe.innKoe(e1);
		koe.utKoe();
		koe.innKoe(e2);
		koe.innKoe(e3);
		koe.utKoe();
		assertEquals(e3, koe.foerste());
	}
	
}
