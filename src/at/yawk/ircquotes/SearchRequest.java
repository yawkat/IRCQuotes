package at.yawk.ircquotes;

import java.io.IOException;

public interface SearchRequest {
    Quote[] getBlock(int blockIndex) throws IOException;
}
