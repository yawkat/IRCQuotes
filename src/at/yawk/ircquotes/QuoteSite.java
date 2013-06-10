package at.yawk.ircquotes;

import java.io.IOException;

public abstract class QuoteSite {
    public abstract SearchRequest createRequest(SearchQuery query);
    
    public abstract Quote getQuoteForId(int id) throws IOException;
    
    protected Quote createQuote(int id, String quote, Author author) {
        return new QuoteImpl(id, quote, author);
    }
    
    protected Author createAuthor(int id, String name) {
        return new AuthorImpl(id, name);
    }
    
    protected class QuoteImpl implements Quote {
        private final int id;
        private final String quote;
        private final Author author;
        
        public QuoteImpl(int id, String quote, Author author) {
            this.id = id;
            this.quote = quote;
            this.author = author;
        }
        
        @Override
        public int getId() {
            return id;
        }
        
        @Override
        public String getQuote() {
            return quote;
        }
        
        @Override
        public Author getAuthor() {
            return author;
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + getOuterType().hashCode();
            result = prime * result + ((author == null) ? 0 : author.hashCode());
            result = prime * result + id;
            result = prime * result + ((quote == null) ? 0 : quote.hashCode());
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            QuoteImpl other = (QuoteImpl) obj;
            if (!getOuterType().equals(other.getOuterType())) {
                return false;
            }
            if (author == null) {
                if (other.author != null) {
                    return false;
                }
            } else if (!author.equals(other.author)) {
                return false;
            }
            if (id != other.id) {
                return false;
            }
            if (quote == null) {
                if (other.quote != null) {
                    return false;
                }
            } else if (!quote.equals(other.quote)) {
                return false;
            }
            return true;
        }

        private QuoteSite getOuterType() {
            return QuoteSite.this;
        }
        
        @Override
        public String toString() {
            return "QuoteImpl [id=" + id + ", quote=" + quote + ", author=" + author + "]";
        }
    }
    
    protected class AuthorImpl implements Author {
        private final int id;
        private final String name;
        
        public AuthorImpl(int id, String name) {
            this.id = id;
            this.name = name;
        }
        
        @Override
        public int getId() {
            return id;
        }
        
        @Override
        public String getName() {
            return name;
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + getOuterType().hashCode();
            result = prime * result + id;
            result = prime * result + ((name == null) ? 0 : name.hashCode());
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            AuthorImpl other = (AuthorImpl) obj;
            if (!getOuterType().equals(other.getOuterType())) {
                return false;
            }
            if (id != other.id) {
                return false;
            }
            if (name == null) {
                if (other.name != null) {
                    return false;
                }
            } else if (!name.equals(other.name)) {
                return false;
            }
            return true;
        }

        private QuoteSite getOuterType() {
            return QuoteSite.this;
        }

        @Override
        public String toString() {
            return "AuthorImpl [id=" + id + ", name=" + name + "]";
        }
    }
}
