package responses;

import java.util.List;

public class UtilFunctionResponse {

	List<Entita> oggetti;
	
	public List<Entita> getOggetti() {
		return oggetti;
	}

	public void setOggetti(List<Entita> oggetti) {
		this.oggetti = oggetti;
	}

	public static class Entita {
		String nome;
		List<Elemento> elementi;
		
		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public List<Elemento> getElementi() {
			return elementi;
		}

		public void setElementi(List<Elemento> elementi) {
			this.elementi = elementi;
		}

		public class Elemento{
			String nome;
			public String getNome() {
				return nome;
			}
			public void setNome(String nome) {
				this.nome = nome;
			}
			public String getThumb() {
				return thumb;
			}
			public void setThumb(String thumb) {
				this.thumb = thumb;
			}
			public String getFile() {
				return file;
			}
			public void setFile(String file) {
				this.file = file;
			}
			String thumb;
			String file;
		}
	}
	
}
