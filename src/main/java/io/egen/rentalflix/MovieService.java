package io.egen.rentalflix;

/**
 * Service implementing IFlix interface
 * You can use any Java collection type to store movies
 */
public class MovieService implements IFlix {
	
	private List<Movie> movieList=null;;
	private static MovieService ms=null;
	
	private MovieService(){
		movieList=new ArrayList<Movie>();
	}
	
	public synchronized static MovieService getMovieServiceInstance(){
		if(ms==null){
			ms=new MovieService();
		}
		return ms;
	}
	/**
	 * Finds all available movies in the movie store
	 * @return list of movies or empty list
	 */
	public List<Movie> findAll(){
		try{
		return this.movieList;
		}
		catch(Exception e){
			System.out.println(e.printStackTrace());
			return null;
		}
	}
	
	/**
	 * Finds all movies in the movie store which contains <strong>name</strong> in the title
	 * @param name String
	 * @return list of movies or empty list
	 */
	public List<Movie> findByName (String name){
		try{
		List<Movie> ret=new ArrayList<Movie>();
		String temp=null;
		for(Movie m:this.movieList){
			temp=m.getTitle(); 
			if(temp.contains(name)){
				ret.add(m);
			}
		}
		return ret;
		}
		catch(Exception e){
			System.out.println(e.printStackTrace());
			return null;
		}
	}
	
	/**
	 * Create a new movie in the movie store
	 * @param movie
	 * @return Movie
	 */
	public Movie create (Movie movie){
		try{
			this.movieList.add(movie);
			return movie;
		}
		catch(Exception e){
			System.out.println(e.printStackTrace());
			return null;
		}
	}
	
	/**
	 * Update an existing movie
	 * @param movie
	 * @return updated movie or throws <strong>IllegalArgumentException</strong> if movie with this id is not found
	 */
	public Movie update (Movie movie){
		try{
			for(Movie m:this.movieList){
				if(m.getId()==movie.getId()){
					this.movieList.remove(m);
					this.movieList.add(movie);
					return m;
				}
			}
			throw new IllegalArgumentException();
		}
		catch(IllegalArgumentException e){
			System.out.println("Movie with this id "+movie.getId()+" is not found.");
			return null;
		}
		catch(Exception e){
			System.out.println(e.printStackTrace());
			return null;
		}
	}
	
	/**
	 * Delete an existing movie 
	 * @param id
	 * @return deleted movie or throws <strong>IllegalArgumentException</strong> if movie with this id is not found
	 */
	public Movie delete (int id){
		try{
			for(Movie m:this.movieList){
				if(m.getId()==id){
					movieList.remove(m);
				}
			}
			throw new IllegalArgumentException();
		}
		catch(IllegalArgumentException e){
			System.out.println("Movie with this id "+movie.getId()+" is not found.");
			return null;
		}
		catch(Exception e){
			System.out.println(e.printStackTrace());
			return null;
		}
	}
	
	/**
	 * Rent the movie with movieId to the <strong>user</strong>.
	 * Make sure this movie is not rented already. 
	 * If it is already rented, throw <strong>IllegalArgumentException</strong>
	 * @param movieId
	 * @param user
	 * @return true: if movie can be rented, false otherwise
	 */
	public boolean rentMovie (int movieId, String user){
		try{
			for(Movie m:this.movieList){
				if(m.getId()==movieId){
					if(!m.getRented()){
						m.setRented(true);
						m.setUser(user);
						return true;
					}else{
						throw new IllegalArgumentException(); 
					}
				}
			}
			return false;
		}
		catch(IllegalArgumentException e){
			System.out.println("Movie with this id "+movie.getId()+" is aleardy rented.");
			return false;
		}
		catch(Exception e){
			System.out.println(e.printStackTrace());
			return false;
		}
	}
}
