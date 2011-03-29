/*
 * Copyright 2011 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.social.web.connect;

import java.io.Serializable;
import java.security.Principal;

import org.springframework.web.context.request.WebRequest;

/**
 * Default account ID extractor that uses the principal name as the account ID.
 */
class DefaultAccountIdExtractor implements AccountIdExtractor {

	public Serializable extractAccountId(WebRequest request) {
		Principal principal = request.getUserPrincipal();
		if (principal == null) {
			throw new IllegalStateException("Unable to extract accountId by calling [request.getUserPrincipal#getName()]: No principal set on the current request");
		}
		return principal.getName(); 
	}

}
