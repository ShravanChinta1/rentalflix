package io.egen.rentalflix;
import org.junit.Test;
/**
 * JUnit test cases for MovieService
 */
public class MovieServiceTest extends TestCase{
	
	private MovieService ms=MovieService.getMovieServiceInstance();
	
	@Test
	public void testFindAll(){
		MovieService ms=MovieService.getMovieServiceInstance();
		List<Movie> result=ms.findAll();
		assertNotNull(result);
	}
	
	@Test
	public void testFindByName(){
		MovieService ms=MovieService.getMovieServiceInstance();
		Movie movie=new Movie(1,"Testo",1999,"English");
		ms.create(movie);
		List<Movie> result1=ms.findByName("Test");
		assertEquals(result1.size(),1);
		List<Movie> result2=ms.findByName("Z");
		assertEquals(result2.size(),0);
	}
	
	@Test
	public void testCreate(){
		MovieService ms=MovieService.getMovieServiceInstance();
		Movie movie=new Movie(1,"Testo",1999,"English");
		Movie result=ms.create(movie);
		assertNotNull(result);
		assertEquals(movie,result);
		
	}
		
	@Test
	public void testUpdate(){
		MovieService ms=MovieService.getMovieServiceInstance();
		Movie movie1=new Movie(1,"Testo",1999,"English");
		ms.create(movie1);
		Movie movie2=new Movie(1,"Testi",1999,"English");
		Movie result=ms.update(movie2);
		assertNotNull(result);
		assertEquals(movie2,result);
	}
	
	@Test
	public void testDelete(){
		MovieService ms=MovieService.getMovieServiceInstance();
		Movie movie=new Movie(1,"Testo",1999,"English");
		ms.create(movie1);
		Movie result=ms.delete(1);
		assertNotNull(result);
		assertEquals(movie,result);
	}
	
	@Test
	public void testRentMovie(){
		MovieService ms=MovieService.getMovieServiceInstance();
		Movie movie=new Movie(1,"Testo",1998,"English");
		ms.create(movie);
		boolean result=ms.rentMovie(1,"user");
		assertTrue(result);
		
	}
}
