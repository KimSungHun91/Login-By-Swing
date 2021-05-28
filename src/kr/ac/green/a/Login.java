package kr.ac.green.a;

class Login {
	private Join id;
	private Join pw;
	
	public Login(Join id, Join pw) {
		setId(id);
		setPw(pw);
	}

	public Join getId() {
		return id;
	}

	public void setId(Join id) {
		this.id = id;
	}

	public Join getPw() {
		return pw;
	}

	public void setPw(Join pw) {
		this.pw = pw;
	}
	
	@Override
	public boolean equals(Object o){
		if(o==null || !(o instanceof Login)){
			return false;
		}
		Login other = (Login) o;
		return getId().equals(other.getId());
	}

	@Override
	public String toString() {
		return "Login [id=" + id + ", pw=" + pw + "]";
	}
	
}
