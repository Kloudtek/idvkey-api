/*
 * Copyright (c) 2016 Kloudtek Ltd
 */

package com.kloudtek.idvkey.api;

import javax.validation.constraints.NotNull;
import javax.ws.rs.*;

/**
 * Interface of JAX-RS IDVKey REST API server
 */
@Path("/notifications")
public interface NotificationAPIService {
    /**
     * Get the user ref for the user authenticated with that operation id
     *
     * @param opId          Operation id
     * @param preIdentified Indicates if the user has been pre-identified by the service/website or not.
     * @return User ref
     */
    @GET
    @Path("authentication/{opId}")
    @Produces("application/json")
    @AuthenticateCustomer
    AuthenticationRequestStatus getAuthenticationStatus(@NotNull @PathParam("opId") String opId, @QueryParam("preId") Boolean preIdentified);

    @GET
    @Path("approval/{opId}")
    @AuthenticateCustomer
    @Produces("application/json")
    ApprovalRequestStatus getUserApprovalState(@NotNull @PathParam("opId") String opId);
}
