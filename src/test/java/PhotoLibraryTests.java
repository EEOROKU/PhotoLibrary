
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

import photos.Photograph;
import photos.PhotoLibrary;

public class PhotoLibraryTests {	

	@Nested
	class FirstTests {

		@Timeout(100)
		@Test
		public void constructor() {
			PhotoLibrary b = new PhotoLibrary("Arphaxad", 14);
			assertEquals("Arphaxad", b.getName(), "PhotoLibrary's constructor failed to initialize name (getter did not return expected value)");
			assertEquals(14, b.getId(), "PhotoLibrary's constructor failed to initialize id (getter did not return expected value)");
			assertEquals(new ArrayList<Photograph>(), b.getPhotos(), "PhotoLibrary's constructor failed to initialize photos (getter did not return expected value)");
		}

		@Timeout(100)
		@Test
		public void setName() {
			PhotoLibrary b = new PhotoLibrary("Arphaxad", 14);
			b.setName("Peleg");
			assertEquals("Peleg", b.getName(), "PhotoLibrary.setName() failed (getter did not return expected value)");
		}


		@Timeout(100)
		@Test
		public void eraseEmpty() {
			PhotoLibrary b = new PhotoLibrary("Peleg", 17);
			assertFalse(b.erasePhoto(new Photograph("T", "A")), "PhotoLibrary.erasePhoto() failed (edge case)");
		}

		@Timeout(100)
		@Test
		public void eraseOnly() {
			PhotoLibrary b = new PhotoLibrary("Peleg", 17);
			b.getPhotos().add(new Photograph("T", "A"));
			assertTrue(b.erasePhoto(new Photograph("T", "A")), "PhotoLibrary.erasePhoto() failed (erasePhoto() returned wrong result) (also check getPhotos())");
			assertEquals(new ArrayList<Photograph>(), b.getPhotos(), "PhotoLibrary.erasePhoto() failed (something wasn't removed) (also check getPhotos())");
		}

		@Timeout(100)
		@Test
		public void eraseThere() {
			PhotoLibrary b = new PhotoLibrary("Peleg", 17);
			b.getPhotos().add(new Photograph("T1", "A1"));
			b.getPhotos().add(new Photograph("T2", "A2"));
			b.getPhotos().add(new Photograph("T3", "A3"));
			assertTrue(b.erasePhoto(new Photograph("T2", "A2")));
			assertFalse(b.getPhotos().contains(new Photograph("T2", "A2")), "PhotoLibrary.erasePhoto() failed (something wasn't removed) (also check getPhotos())");
			assertTrue(b.getPhotos().contains(new Photograph("T1", "A1")), "PhotoLibrary.erasePhoto() failed (removed too much) (also check getPhotos())");
			assertTrue(b.getPhotos().contains(new Photograph("T3", "A3")), "PhotoLibrary.erasePhoto() failed (removed too much) (also check getPhotos())");
		}

		@Timeout(100)
		@Test
		public void eraseNotThere() {
			PhotoLibrary b = new PhotoLibrary("Peleg", 17);
			b.getPhotos().add(new Photograph("T1", "A1"));
			b.getPhotos().add(new Photograph("T3", "A3"));
			assertFalse(b.erasePhoto(new Photograph("T2", "A2")));
			assertFalse(b.getPhotos().contains(new Photograph("T2", "A2")), "PhotoLibrary.erasePhoto() failed (added instead of removed) (also check getPhotos())");
			assertTrue(b.getPhotos().contains(new Photograph("T1", "A1")), "PhotoLibrary.erasePhoto() failed (removed too much) (also check getPhotos())");
			assertTrue(b.getPhotos().contains(new Photograph("T3", "A3")), "PhotoLibrary.erasePhoto() failed (removed too much) (also check getPhotos())");
		}


		@Timeout(100)
		@Test
		public void testAddNull() {
			PhotoLibrary b = new PhotoLibrary("Arphaxad", 14);
			//assertTrue("PhotoLibrary.addPhoto() failed (edge case)", b.addPhoto(null));
			if (b.addPhoto(null)) {
				assertTrue(b.getPhotos().contains(null), "PhotoLibrary.addPhoto() failed (edge case)");
			} else {
				assertFalse(b.getPhotos().contains(null), "PhotoLibrary.addPhoto() failed (edge case)");
			}
		}

		@Timeout(100)
		@Test
		public void testaddPhoto() {
			PhotoLibrary b = new PhotoLibrary("Arphaxad", 14);
			Photograph k = new Photograph("some title", "some author");
			assertTrue(b.addPhoto(k), "PhotoLibrary.addPhoto() failed");
			assertTrue(b.getPhotos().contains(k), "PhotoLibrary.addPhoto() failed (photos list doesn't include taken photo)");
		}

		@Timeout(100)
		@Test
		public void testAddTwoPhotographs() {
			PhotoLibrary b = new PhotoLibrary("Arphaxad", 14);
			Photograph k = new Photograph("some title", "some author");
			Photograph k2 = new Photograph("another title", "same author");
			assertTrue(b.addPhoto(k), "PhotoLibrary.addPhoto() failed");
			assertTrue(b.addPhoto(k2), "PhotoLibrary.addPhoto() failed");
			assertTrue(b.getPhotos().contains(k), "PhotoLibrary.addPhoto() failed (photos list doesn't include taken photo)");
			assertTrue(b.getPhotos().contains(k2), "PhotoLibrary.addPhoto() failed (photos list doesn't include taken photo)");
		}

		@Timeout(100)
		@Test
		public void testAddSamePhotographTwice() {
			PhotoLibrary b = new PhotoLibrary("Arphaxad", 14);
			Photograph k = new Photograph("some title", "some author");
			Photograph k2 = new Photograph("another title", "same author");
			Photograph k3 = new Photograph("another title", "another author");
			assertTrue(b.addPhoto(k), "PhotoLibrary.addPhoto() failed");
			assertTrue(b.addPhoto(k2), "PhotoLibrary.addPhoto() failed");
			assertTrue(b.addPhoto(k3), "PhotoLibrary.addPhoto() failed");
			assertFalse(b.addPhoto(k2), "PhotoLibrary.addPhoto() failed");
			assertEquals(3, b.getPhotos().size(), "PhotoLibrary.addPhoto() failed (photos list reports wrong size after taking photos)");
		}

		@Timeout(100)
		@Test
		public void testAddTwoCopies() {
			PhotoLibrary b = new PhotoLibrary("Arphaxad", 14);
			Photograph k = new Photograph("some title", "some author");
			Photograph k2 = new Photograph("another title", "same author");
			Photograph k3 = new Photograph("another title", "same author");
			assertTrue(b.addPhoto(k), "PhotoLibrary.addPhoto() failed");
			assertTrue(b.addPhoto(k2), "PhotoLibrary.addPhoto() failed");
			assertFalse(b.addPhoto(k3), "PhotoLibrary.addPhoto() failed (adding an equal photograph)");
			assertEquals(2, b.getPhotos().size(), "PhotoLibrary.addPhoto() failed (photos list reports wrong size after taking photos)");
		}


		@Timeout(100)
		@Test
		public void testNum0() {
			PhotoLibrary b = new PhotoLibrary("Arphaxad", 14);
			assertEquals(0, b.numPhotographs(), "PhotoLibrary.numPhotographs() failed (edge case)");
		}

		@Timeout(100)
		@Test
		public void testNum1() {
			PhotoLibrary b = new PhotoLibrary("Arphaxad", 14);
			b.getPhotos().add(new Photograph("T", "A"));
			assertEquals(1, b.numPhotographs(), "PhotoLibrary.numPhotographs() failed (short list) (also check getPhotos())");
		}

		@Timeout(100)
		@Test
		public void testNum2() {
			PhotoLibrary b = new PhotoLibrary("Arphaxad", 14);
			b.getPhotos().add(new Photograph("T", "A"));
			b.getPhotos().add(new Photograph("Title", "A"));
			assertEquals(2, b.numPhotographs(), "PhotoLibrary.numPhotographs() failed (short list) (also check getPhotos())");
		}

		@Timeout(100)
		@Test
		public void testNum3() {
			PhotoLibrary b = new PhotoLibrary("Arphaxad", 14);
			b.getPhotos().add(new Photograph("T", "A"));
			b.getPhotos().add(new Photograph("Title", "A"));
			b.getPhotos().add(null);
			assertEquals(3, b.numPhotographs(), "PhotoLibrary.numPhotographs() failed (edge case) (also check getPhotos())");
		}


		@Timeout(100)
		@Test
		public void testhasPhotoEmpty() {
			PhotoLibrary b = new PhotoLibrary("Arphaxad", 14);
			Photograph k = new Photograph("some title", "some author");
			assertFalse(b.hasPhoto(k), "PhotoLibrary.hasPhoto() failed (edge case)");
		}

		@Timeout(100)
		@Test
		public void testhasPhoto() {
			PhotoLibrary b = new PhotoLibrary("Arphaxad", 14);
			Photograph k = new Photograph("some title", "some author");
			Photograph k2 = new Photograph("another title", "same author");
			Photograph k3 = new Photograph("another title", "another author");
			b.getPhotos().add(k);
			b.getPhotos().add(k2);
			b.getPhotos().add(k3);
			assertTrue(b.hasPhoto(k2), "PhotoLibrary.hasPhoto() failed (also check getPhotos())");
		}

		@Timeout(100)
		@Test
		public void testHasNotRead() {
			PhotoLibrary b = new PhotoLibrary("Arphaxad", 14);
			Photograph k = new Photograph("some title", "some author");
			Photograph k2 = new Photograph("another title", "same author");
			Photograph k3 = new Photograph("another title", "another author");
			b.getPhotos().add(k);
			b.getPhotos().add(k2);
			assertFalse(b.hasPhoto(k3), "PhotoLibrary.hasPhoto() failed (also check getPhotos())");
		}


		@Timeout(100)
		@Test
		public void equalsType() throws Exception {
			try {
				PhotoLibrary.class.getDeclaredMethod("equals", Object.class);
			} catch (NoSuchMethodException e) {
				fail("PhotoLibrary equals method not specified correctly.");
			} catch (Exception e) {
				throw e;
			}
		}

		@Timeout(100)
		@Test
		public void equalsSame() {
			PhotoLibrary b = new PhotoLibrary("Le Petit Prince", 42);
			assertTrue(b.equals(b), "PhotoLibrary.equals() failed: Symmetric");
		}

		@Timeout(100)
		@Test
		public void equalsSimilar() {
			PhotoLibrary b = new PhotoLibrary("Le Petit Prince", 42);
			PhotoLibrary c = new PhotoLibrary("Le Petit Prince", 42);
			assertTrue(b.equals(c), "PhotoLibrary.equals() failed: Same id and name");
		}

		@Timeout(100)
		@Test
		public void equalsDifferentNames() {
			PhotoLibrary b = new PhotoLibrary("Le Petit Prince", 42);
			PhotoLibrary c = new PhotoLibrary("The Little Prince", 42);
			assertTrue(b.equals(c), "PhotoLibrary.equals() failed: Same id, different names");
		}

		@Timeout(100)
		@Test
		public void equalsDifferentReads() {
			PhotoLibrary b = new PhotoLibrary("Le Petit Prince", 42);
			PhotoLibrary c = new PhotoLibrary("Le Petit Prince", 42);
			((ArrayList<Photograph>) c.getPhotos()).add(new Photograph("Picture of a Sheep", "Me"));
			assertTrue(b.equals(c), "PhotoLibrary.equals() failed: Same id, different names");
		}

		@Timeout(100)
		@Test
		public void equalsDifferentIds() {
			PhotoLibrary b = new PhotoLibrary("Le Petit Prince", 42);
			PhotoLibrary c = new PhotoLibrary("Le Petit Prince", 2110);
			assertFalse(b.equals(c), "PhotoLibrary.equals() failed: Different id, same names");
		}

		@Timeout(100)
		@Test
		public void equalsEverythingDifferent() {
			PhotoLibrary b = new PhotoLibrary("Le Petit Prince", 42);
			PhotoLibrary c = new PhotoLibrary("The Little Prince", 2110);
			assertFalse(b.equals(c), "PhotoLibrary.equals() failed: Different id, different names");
		}

		@Timeout(100)
		@Test
		public void equalsDifferentTypes() throws Exception {
			try {
				PhotoLibrary b = new PhotoLibrary("Le Petit Prince", 42);
				assertFalse(b.equals(42), "PhotoLibrary.equals() failed: Compare PhotoLibrary to Integer");
			} catch (ClassCastException e) {
				fail("PhotoLibrary.equals() failed: Casting a non-PhotoLibrary to a PhotoLibrary");
			} catch (Exception e) {
				throw e;
			}
		}

		@Timeout(100)
		@Test
		public void testToString() {
			PhotoLibrary b = new PhotoLibrary("Le Petit Prince", 402);
			b.getPhotos().add(new Photograph("Picture of a Sheep", "Me"));
			String s = b.toString();
			assertTrue(s.contains("Le Petit Prince"), "PhotoLibrary.toString must have name");
			assertTrue(s.contains("402"), "PhotoLibrary.toString must have id");
			assertTrue(s.contains("Me"), "PhotoLibrary.toString must have list of Photographs (also check getPhotos())");
			assertTrue(s.contains("Picture of a Sheep"), "PhotoLibrary.toString must have list of Photographs (also check getPhotos())");
		}
	}



	@Timeout(100)
	@Test
	public void testEmptyCommon() {
		PhotoLibrary a = new PhotoLibrary("Dana", 1);
		PhotoLibrary b = new PhotoLibrary("Chris", 2);
		assertEquals(new ArrayList<Photograph>(), PhotoLibrary.commonPhotos(a,b),"PhotoLibrary.commonPhotos() failed (edge case)");
	}

	@Timeout(100)
	@Test
	public void testNoneInCommon() {
		PhotoLibrary a = new PhotoLibrary("Dana", 1);
		PhotoLibrary b = new PhotoLibrary("Chris", 2);
		Photograph x = new Photograph("One Cello x 16", "Keating");
		Photograph y = new Photograph("One Cello x 16", "Zoe Keating");
		Photograph z = new Photograph("Palladino", "Jenkins");
		a.addPhoto(x);
		b.addPhoto(y);
		a.addPhoto(z);
		int asize = a.getPhotos().size();
		int bsize = b.getPhotos().size();
		assertEquals(new ArrayList<Photograph>(), PhotoLibrary.commonPhotos(a,b),"PhotoLibrary.commonPhotos() failed (also check addPhoto())");
		assertEquals(new ArrayList<Photograph>(), PhotoLibrary.commonPhotos(a,b),"PhotoLibrary.commonPhotos() failed (also check addPhoto())");
		assertEquals(asize, a.getPhotos().size(),"PhotoLibrary.commonPhotos() failed: read lists should not change (also check addPhoto())");
		assertEquals(bsize, b.getPhotos().size(),"PhotoLibrary.commonPhotos() failed: read lists should not change (also check addPhoto())");
	}
	@Timeout(100)
	@Test
	public void testAllInCommon() {
		PhotoLibrary a = new PhotoLibrary("Dana", 1);
		PhotoLibrary b = new PhotoLibrary("Chris", 2);
		Photograph x = new Photograph("One Cello x 16", "Keating");
		Photograph y = new Photograph("One Cello x 16", "Zoe Keating");
		Photograph z = new Photograph("Palladino", "Jenkins");
		a.addPhoto(x); b.addPhoto(z);
		a.addPhoto(y); b.addPhoto(x);
		a.addPhoto(z); b.addPhoto(y);
		int asize = a.getPhotos().size();
		int bsize = b.getPhotos().size();
		ArrayList<Photograph> common = PhotoLibrary.commonPhotos(a, b);
		assertTrue(common.contains(x),"PhotoLibrary.commonPhotos() failed (also check addPhoto())");
		assertTrue(common.contains(y),"PhotoLibrary.commonPhotos() failed (also check addPhoto())");
		assertTrue(common.contains(z),"PhotoLibrary.commonPhotos() failed (also check addPhoto())");
		assertEquals(3, common.size(),"PhotoLibrary.commonPhotos() failed: Three shared photos, but PhotoLibrarys had more than 3 shared reported");
		assertEquals(asize, a.getPhotos().size(),"PhotoLibrary.commonPhotos() failed: photos lists should not change on call to commonPhotos() (also check getPhotos())");
		assertEquals(bsize, b.getPhotos().size(),"PhotoLibrary.commonPhotos() failed: photos lists should not change on call to commonPhotos() (also check getPhotos())");
	}

	@Timeout(100)
	@Test
	public void testOneInCommon() {
		PhotoLibrary a = new PhotoLibrary("Dana", 1);
		PhotoLibrary b = new PhotoLibrary("Chris", 2);
		Photograph x = new Photograph("One Cello x 16", "Keating");
		Photograph y = new Photograph("One Cello x 16", "Zoe Keating");
		Photograph z = new Photograph("Palladino", "Jenkins");
		a.addPhoto(x); 
		a.addPhoto(y); b.addPhoto(y);
		b.addPhoto(z);
		int asize = a.getPhotos().size();
		int bsize = b.getPhotos().size();
		ArrayList<Photograph> common = PhotoLibrary.commonPhotos(a, b);
		assertTrue(common.contains(y),"PhotoLibrary.commonPhotos() failed (also check addPhoto())");
		assertEquals(1, common.size(),"PhotoLibrary.commonPhotos() failed: PhotoLibrarys with overlapping photos should only report shared photos");
		assertEquals(asize, a.getPhotos().size(),"PhotoLibrary.commonPhotos() failed: photos lists should not change on call to commonPhotos() (also check getPhotos())");
		assertEquals(bsize, b.getPhotos().size(),"PhotoLibrary.commonPhotos() failed: photos lists should not change on call to commonPhotos() (also check getPhotos())");
	}

	@Timeout(100)
	@Test
	public void testEmptySimilarity() {
		PhotoLibrary a = new PhotoLibrary("Dana", 1);
		PhotoLibrary b = new PhotoLibrary("Chris", 2);
		assertEquals(0.0, PhotoLibrary.similarity(a,b), 1e-6, "PhotoLibrary.similarity() failed: edge case (no photos)"); // 1e-6 = epsilon
		Photograph z = new Photograph("Palladino", "Jenkins");
		b.addPhoto(z);
		int asize = a.getPhotos().size();
		int bsize = b.getPhotos().size();
		assertEquals(0.0, PhotoLibrary.similarity(a,b), 1e-6,"PhotoLibrary.similarity() failed: no shared photos (also check addPhoto())"); // 1e-6 = epsilon
		assertEquals(0.0, PhotoLibrary.similarity(b,a), 1e-6,"PhotoLibrary.similarity() failed: no shared photos (also check addPhoto())"); // 1e-6 = epsilon
		assertEquals(asize, a.getPhotos().size(),"PhotoLibrary.similarity() failed: photos lists should not change (also check getPhotos())");
		assertEquals(bsize, b.getPhotos().size(),"PhotoLibrary.similarity() failed: photos lists should not change (also check getPhotos())");
	}
	@Timeout(100)
	@Test
	public void testFullSimilarity() {
		PhotoLibrary a = new PhotoLibrary("Dana", 1);
		PhotoLibrary b = new PhotoLibrary("Chris", 2);
		Photograph x = new Photograph("One Cello x 16", "Keating");
		Photograph y = new Photograph("One Cello x 16", "Zoe Keating");
		Photograph z = new Photograph("Palladino", "Jenkins");
		a.addPhoto(x); b.addPhoto(x);
		a.addPhoto(y); b.addPhoto(y);
		a.addPhoto(z); b.addPhoto(z);
		int asize = a.getPhotos().size();
		int bsize = b.getPhotos().size();
		assertEquals(1.0, PhotoLibrary.similarity(a,b), 1e-6, "PhotoLibrary.similarity() failed: shared 3 photos and with no other photos (also check addPhoto())"); // 1e-6 = epsilon
		assertEquals(asize, a.getPhotos().size(), "PhotoLibrary.similarity() failed: photos lists should not change (also check getPhotos())");
		assertEquals(bsize, b.getPhotos().size(), "PhotoLibrary.similarity() failed: photos lists should not change (also check getPhotos())");
	}
	@Timeout(100)
	@Test
	public void test2of3Similarity() {
		PhotoLibrary a = new PhotoLibrary("Dana", 1);
		PhotoLibrary b = new PhotoLibrary("Chris", 2);
		Photograph x = new Photograph("One Cello x 16", "Keating");
		Photograph y = new Photograph("One Cello x 16", "Zoe Keating");
		Photograph z = new Photograph("Palladino", "Jenkins");
		a.addPhoto(x); b.addPhoto(x);
		a.addPhoto(y);
		b.addPhoto(z);
		int asize = a.getPhotos().size();
		int bsize = b.getPhotos().size();
		assertEquals(0.5, PhotoLibrary.similarity(a,b), 1e-6, "PhotoLibrary.similarity() failed: one shared photo, but they have additional unshared photo(s) (also check addPhoto())"); // 1e-6 = epsilon
		assertEquals(asize, a.getPhotos().size(), "PhotoLibrary.similarity() failed: photos lists should not change (also check getPhotos())");
		assertEquals(bsize, b.getPhotos().size(), "PhotoLibrary.similarity() failed: photos lists should not change (also check getPhotos())");
	}
	@Timeout(100)
	@Test
	public void testFirstFullSimilarity() {
		PhotoLibrary a = new PhotoLibrary("Dana", 1);
		PhotoLibrary b = new PhotoLibrary("Chris", 2);
		Photograph x = new Photograph("One Cello x 16", "Keating");
		Photograph y = new Photograph("One Cello x 16", "Zoe Keating");
		Photograph z = new Photograph("Palladino", "Jenkins");
		a.addPhoto(x); b.addPhoto(x);
		a.addPhoto(y);
		int asize = a.getPhotos().size();
		int bsize = b.getPhotos().size();
		assertEquals(1.0, PhotoLibrary.similarity(a,b), 1e-6, "PhotoLibrary.similarity() failed: one-way overlap (one person has taken all photos another has) (also check addPhoto())"); // 1e-6 = epsilon
		assertEquals(asize, a.getPhotos().size(), "PhotoLibrary.similarity() failed: photos lists should not change (also check getPhotos())");
		assertEquals(bsize, b.getPhotos().size(), "PhotoLibrary.similarity() failed: photos lists should not change (also check getPhotos())");
	}
	@Timeout(100)
	@Test
	public void testSecondFullSimilarity() {
		PhotoLibrary a = new PhotoLibrary("Dana", 1);
		PhotoLibrary b = new PhotoLibrary("Chris", 2);
		Photograph x = new Photograph("One Cello x 16", "Keating");
		Photograph y = new Photograph("One Cello x 16", "Zoe Keating");
		Photograph z = new Photograph("Palladino", "Jenkins");
		a.addPhoto(x); b.addPhoto(x);
		b.addPhoto(y);
		a.addPhoto(z); b.addPhoto(z);
		int asize = a.getPhotos().size();
		int bsize = b.getPhotos().size();
		assertEquals(1.0, PhotoLibrary.similarity(a,b), 1e-6, "PhotoLibrary.similarity() failed: one-way overlap (one person has taken all photos another has) (also check addPhoto())"); // 1e-6 = epsilon
		assertEquals(asize, a.getPhotos().size(), "PhotoLibrary.similarity() failed: photos lists should not change (also check getPhotos())");
		assertEquals(bsize, b.getPhotos().size(), "PhotoLibrary.similarity() failed: photos lists should not change (also check getPhotos())");
	}

}

