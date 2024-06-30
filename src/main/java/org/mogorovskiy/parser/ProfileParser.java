package org.mogorovskiy.parser;

import org.mogorovskiy.model.Attorney;
import org.mogorovskiy.model.AttorneyProfileSource;

public interface ProfileParser {
    Attorney parse(AttorneyProfileSource attorneySource);
}
